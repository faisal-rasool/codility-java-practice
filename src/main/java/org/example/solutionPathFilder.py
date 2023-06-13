import os, pathlib
import random


class CellItems:
    gUp = "^"
    gLeft = "<"
    gDown = "v"
    gRight = ">"
    Object = "X"
    Nothing = "."
    Assassin = "A"
    vUpDown = "\u2551"
    vLeftRight = "\u2550"
    vCross = "\u256C"
    vBlocking = [Object, gUp, gDown, gLeft, gRight]
    Flooded = "?"
    ExcessFlood = "!"


class bcolors:
    GREEN = "\033[92m"
    YELLOW = "\033[93m"
    BLUE = "\033[94m"
    CYAN = "\033[96m"
    RED = "\033[91m"
    ENDC = "\033[0m"
    REVERSE = "\033[07m"


dict_guardFacing = {
    1: CellItems.gUp,
    2: CellItems.gDown,
    3: CellItems.gLeft,
    4: CellItems.gRight,
}

dict_Colours = {
    CellItems.gDown: bcolors.RED,
    CellItems.gRight: bcolors.RED,
    CellItems.gLeft: bcolors.RED,
    CellItems.gUp: bcolors.RED,
    CellItems.vUpDown: bcolors.YELLOW,
    CellItems.vLeftRight: bcolors.YELLOW,
    CellItems.vCross: bcolors.YELLOW,
    CellItems.Object: bcolors.CYAN,
    CellItems.Assassin: bcolors.BLUE + bcolors.REVERSE,
    CellItems.Flooded: bcolors.GREEN + bcolors.REVERSE,
    CellItems.ExcessFlood: bcolors.RED + bcolors.REVERSE,
}

mapList = ["Map", "Filled", "Flooded"]


def pRow(thisRow, thisEnd=None):
    printRow = ""
    for thisChar in thisRow:
        if thisChar in dict_Colours.keys():
            printRow = printRow + dict_Colours[thisChar] + thisChar + bcolors.ENDC
        else:
            printRow = printRow + thisChar
    print(printRow, end=thisEnd)


def getInput():
    # read the text line into a list of lists
    with open(os.path.join(pathlib.Path(__file__).parent.resolve(), "input.txt")) as f:
        lines = f.readlines()

    maps = []
    mapNum = 0
    for thisLine in lines:
        thisLine = thisLine.strip().strip("[]")
        thisLine = thisLine.replace("'", "")
        map = thisLine.split(",")
        mapSet = {"Name": f"Map {mapNum}", "Map": map, "Source": "input.txt"}
        maps.append(mapSet)
        mapNum += 1
    return maps


def printMap(printMapSet):
    maxWidthFor3 = 60

    numRows = len(printMapSet["Map"])
    numCols = len(printMapSet["Map"][0])

    if numCols > maxWidthFor3:
        if "Flooded" in printMapSet.keys():
            mapListUse = ["Flooded"]
        elif "Filled" in printMapSet.keys():
            mapListUse = ["Filled"]
        else:
            mapListUse = ["Map"]
    else:
        mapListUse = mapList

    mapSpacer = "    "
    rowPrefixLength = len(str(numRows)) + 1
    print(f"==== Map: {printMapSet['Name']} ====")
    if "Source" in printMapSet.keys():
        print(f"Source: {printMapSet['Source']}")
        if printMapSet["Source"] == "Generated":
            print(f"... Chance of Guard: {printMapSet['ChanceGuard']}")
            print(f"...            Wall: {printMapSet['ChanceWall']}")

    # run some counts
    counts = {}
    counts["Wall"] = str(printMapSet["Map"]).count(CellItems.Object)
    counts["Guards"] = (
        str(printMapSet["Map"]).count(CellItems.gUp)
        + str(printMapSet["Map"]).count(CellItems.gDown)
        + str(printMapSet["Map"]).count(CellItems.gLeft)
        + str(printMapSet["Map"]).count(CellItems.gRight)
    )
    print(
        f"Number of Cells: {numCols * numRows},  Guards: {counts['Guards']},  Walls: {counts['Wall']}"
    )
    if "Flooded" in printMapSet.keys():
        counts["Flooded"] = str(printMapSet["Flooded"]).count(CellItems.Flooded)
        counts["ExcessFlood"] = str(printMapSet["Flooded"]).count(CellItems.ExcessFlood)
        print(f"Flooded: {counts['Flooded'] },  Excess Flood: {counts['ExcessFlood'] }")

    header = "0123456789"
    expandedHeader = (" " * rowPrefixLength) + (header * ((int(numCols / 10) + 1)))[
        0:numCols
    ]

    printedHeader = ""
    for mapType in mapListUse:
        if mapType in printMapSet.keys():
            printedHeader = printedHeader + expandedHeader + mapSpacer
    print(printedHeader)

    for thisLine in range(numRows):
        printMessage = ""
        for mapType in mapListUse:
            if mapType in printMapSet.keys():
                printMessage = (
                    printMessage
                    + str(thisLine).rjust(rowPrefixLength - 1)
                    + "-"
                    + printMapSet[mapType][thisLine]
                    + mapSpacer
                )
        pRow(printMessage)
    print(printedHeader)


def changeRow(thisRow, newChar, newCharCol):
    return thisRow[:newCharCol] + newChar + thisRow[newCharCol + 1 :]


def fillMap(thisMap):
    numRows = len(thisMap)
    numCols = len(thisMap[0])
    assasin = []

    for rowNum in range(numRows):
        for colNum in range(numCols):
            mainCell = thisMap[rowNum][colNum]
            # log tha assassin location
            if mainCell == CellItems.Assassin:
                assasin = [rowNum, colNum]

            match mainCell:
                case CellItems.gLeft:
                    for thisCol in range(colNum - 1, -1, -1):
                        thisCell = thisMap[rowNum][thisCol]
                        match thisCell:
                            case CellItems.Nothing:
                                thisMap[rowNum] = changeRow(
                                    thisMap[rowNum], CellItems.vLeftRight, thisCol
                                )
                            case CellItems.vUpDown:
                                thisMap[rowNum] = changeRow(
                                    thisMap[rowNum], CellItems.vCross, thisCol
                                )
                            case x if thisCell in CellItems.vBlocking:
                                blocked = True
                                break  # leave the for thisCol loop
                case CellItems.gRight:
                    for thisCol in range(colNum + 1, numCols, 1):
                        thisCell = thisMap[rowNum][thisCol]
                        match thisCell:
                            case CellItems.Nothing:
                                thisMap[rowNum] = changeRow(
                                    thisMap[rowNum], CellItems.vLeftRight, thisCol
                                )
                            case CellItems.vUpDown:
                                thisMap[rowNum] = changeRow(
                                    thisMap[rowNum], CellItems.vCross, thisCol
                                )
                            case x if thisCell in CellItems.vBlocking:
                                blocked = True
                                break  # leave the for thisCol loop
                case CellItems.gUp:
                    for thisRow in range(rowNum - 1, -1, -1):
                        thisCell = thisMap[thisRow][colNum]
                        match thisCell:
                            case CellItems.Nothing:
                                thisMap[thisRow] = changeRow(
                                    thisMap[thisRow], CellItems.vUpDown, colNum
                                )
                            case CellItems.vLeftRight:
                                thisMap[thisRow] = changeRow(
                                    thisMap[thisRow], CellItems.vCross, colNum
                                )

                            case x if thisCell in CellItems.vBlocking:
                                blocked = True
                                break  # leave the for thisRow loop
                case CellItems.gDown:
                    for thisRow in range(rowNum + 1, numRows, 1):
                        thisCell = thisMap[thisRow][colNum]
                        match thisCell:
                            case CellItems.Nothing:
                                thisMap[thisRow] = changeRow(
                                    thisMap[thisRow], CellItems.vUpDown, colNum
                                )
                            case CellItems.vLeftRight:
                                thisMap[thisRow] = changeRow(
                                    thisMap[thisRow], CellItems.vCross, colNum
                                )
                            case x if thisCell in CellItems.vBlocking:
                                blocked = True
                                break  # leave the for thisRow loop
    return thisMap, assasin


def floodFill(thisMap, startAtAssassin, excessFlood=False):
    # prime the floodFrom list with the startAtAssasin
    floodFrom = [startAtAssassin]
    numRows = len(thisMap)
    numCols = len(thisMap[0])
    solved = False
    currentFlood = CellItems.Flooded

    while len(floodFrom) != 0:
        # for each cell in flood-from, check adjacent cells (u/d/l/r) are empty
        # if emptry, flood and add to floodFrom

        # get the LAST flood-fill, it's more efficent if you use a break when solved
        lastFlooded = len(floodFrom) - 1
        floodedRow, floodedCol = floodFrom[lastFlooded][0], floodFrom[lastFlooded][1]
        # floodedRow, floodedCol = floodFrom[0][0], floodFrom[0][1]
        # flood up one row
        if floodedRow != 0:
            rowMod = -1
            colMod = 0
            if thisMap[floodedRow + rowMod][floodedCol + colMod] == CellItems.Nothing:
                thisMap[floodedRow + rowMod] = changeRow(
                    thisMap[floodedRow + rowMod], currentFlood, floodedCol + colMod
                )
                floodFrom.append([floodedRow + rowMod, floodedCol + colMod])
        # flood down one row
        if floodedRow != numRows - 1:
            rowMod = +1
            colMod = 0
            if thisMap[floodedRow + rowMod][floodedCol + colMod] == CellItems.Nothing:
                thisMap[floodedRow + rowMod] = changeRow(
                    thisMap[floodedRow + rowMod], currentFlood, floodedCol + colMod
                )
                floodFrom.append([floodedRow + rowMod, floodedCol + colMod])
        # flood left one col
        if floodedCol != 0:
            rowMod = 0
            colMod = -1
            if thisMap[floodedRow + rowMod][floodedCol + colMod] == CellItems.Nothing:
                thisMap[floodedRow + rowMod] = changeRow(
                    thisMap[floodedRow + rowMod], currentFlood, floodedCol + colMod
                )
                floodFrom.append([floodedRow + rowMod, floodedCol + colMod])
        # flood right one col
        if floodedCol != numCols - 1:
            rowMod = 0
            colMod = +1
            if thisMap[floodedRow + rowMod][floodedCol + colMod] == CellItems.Nothing:
                thisMap[floodedRow + rowMod] = changeRow(
                    thisMap[floodedRow + rowMod], currentFlood, floodedCol + colMod
                )
                floodFrom.append([floodedRow + rowMod, floodedCol + colMod])
                # Check if we solved it
                if floodedCol + colMod == numCols - 1:
                    solved = True
                    if excessFlood:
                        currentFlood = CellItems.ExcessFlood
                    else:
                        break

        # remove the one we just did from the list
        floodFrom.remove([floodedRow, floodedCol])

    return thisMap, solved


def buildMapSet(numRows=10, numCols=10, chanceGuard=6, chanceWall=3, thisName=None):
    guardHigh = chanceGuard
    wallHigh = chanceGuard + chanceWall

    # set the Assassin
    assassinRow = random.randint(0, numRows - 1)
    map = []

    for thisRow in range(numRows):
        rowString = ""
        for thisCol in range(numCols):
            if (thisCol == 0) and (thisRow == assassinRow):
                thisCell = CellItems.Assassin
            else:
                thisCellNum = random.randint(1, 100)
                thisCell = ""
                if thisCellNum <= guardHigh and thisCol > 0:
                    # is guard, sort out NSEW facing
                    thisCell = dict_guardFacing[random.randint(1, 4)]
                elif thisCellNum <= wallHigh:
                    # is wall
                    thisCell = CellItems.Object
                else:
                    thisCell = CellItems.Nothing
            rowString = rowString + thisCell
        map.append(rowString)

    # get the mapname
    mapName = thisName
    if not mapName:
        mapName = f"{numRows}x{numCols} Random Map"

    mapSet = {
        "Name": mapName,
        "Map": map,
        "Source": "Generated",
        "ChanceGuard": chanceGuard,
        "ChanceWall": chanceWall,
    }

    # check we have an assasin
    found = False
    for thisRow in map:
        if thisRow[0] == CellItems.Assassin:
            found = True
            break
    if not found:
        raise Exception("No assasin generated!")

    return mapSet


def main():
    mapSets = []
    # mapSets = getInput()
    # mapSets.append(buildMapSet(5,6,10,5))
    # mapSets.append(buildMapSet(15,16,8,10))
    # mapSets.append(buildMapSet(32,48,4,10))
    # mapSets.append(buildMapSet(200,200,3,10))
    mapSets.append(buildMapSet(20, 20, 3, 10))
    for thisMapSet in mapSets:
        thisMapSet["Filled"], thisMapSet["Assassin"] = fillMap(thisMapSet["Map"].copy())
        thisMapSet["Flooded"], thisMapSet["Solved"] = floodFill(
            thisMapSet["Filled"].copy(), thisMapSet["Assassin"], True
        )
        printMap(thisMapSet)
        print(f"Solved? {thisMapSet['Solved']}")
        print("")


main()
