import math

def solution(A: list) -> int:
    nSections = len(A)
    nTrees    = sum(A)
    
    # if all sections have equal number of trees
    # then number of trees in any section equal the average number of trees
    # but each section can only have an integer trees
    # so if the current average is not an integer
    # the new average will be the integer closest integer to it     (if current avg is 2.3 new avg will be 3)

    requiredTreesPerSection = math.ceil(nTrees / nSections)    # new average

    nTreesToPlant = nSections * requiredTreesPerSection - nTrees # total number of trees we want to plant

    # now the number of trees we want to move is equal
    # to the number of trees greater than the new average in 
    # each section

    nTreesToMove = 0
    for i in range(0,len(A)):
        treesInCurrentSection = A[i]

        if treesInCurrentSection > requiredTreesPerSection:
            nTreesToMove += treesInCurrentSection - requiredTreesPerSection

    return nTreesToPlant + nTreesToMove
