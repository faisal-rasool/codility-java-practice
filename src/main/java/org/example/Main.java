package org.example;

public class Main {
    public static void main(String[] args) {


//        BinaryGap sol = new BinaryGap();
//        int result = sol.solution(1041);
//        CountConformingBitmasks sol = new CountConformingBitmasks();
//        int result = sol.solution(1073741727, 1073741631, 1073741679);

//        DemoTask sol = new DemoTask();
//        int result = sol.solution(new int[]{1, 3, 6, 4, 1, 2});

//        CyclicRotation cyclicRotation = new CyclicRotation();
//        int [] result = cyclicRotation.solution(new int[]{},3);

//        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
//        int result = oddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9});

//        FrogJmp frogJmp = new FrogJmp();
//        int result = frogJmp.solution(10, 85, 30);

//        PermMissingElem permMissingElem = new PermMissingElem();
//        int result = permMissingElem.solution(new int[]{1});

//        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
//        int result = tapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3});

//        FrogRiverOne1 frogRiverOne = new FrogRiverOne1();
//        int result = frogRiverOne.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});

//        PermCheck permCheck = new PermCheck();
//        int result = permCheck.solution(new int[]{2});

//        MaxCounters maxCounters = new MaxCounters();
//        int[] result = maxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});

//        MissingInteger missingInteger = new MissingInteger();
//        int result = missingInteger.solution(new int[] {1, 3, 6, 4, 1, 2});

//        PassingCars1 passingCars = new PassingCars1();
//        int result = passingCars.solution(new int[]{0, 1, 0, 1, 1});

//        CountDiv countDiv = new CountDiv();
//        int result = countDiv.solution(11, 345, 17);

//        MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();
//        int result = minAvgTwoSlice.solution(new int[]{4, 2, 2, 5, 1, 5, 8});

//        Distinct distinct = new Distinct();
//        int result = distinct.solution(new int[]{2, 1, 1, 2, 3, 1});

//        MaxProductOfThree maxProductOfThree = new MaxProductOfThree();
//        int result = maxProductOfThree.solution(new int[]{-3, 1, 2, -2, 5, 6});


//        Triangle triangle = new Triangle();
//        int result = triangle.solution(new int[]{10, 2, 5, 1, 8, 20});

//        Brackets brackets = new Brackets();
//        int result = brackets.solution("{[()()]}");

//        Fish fish = new Fish();
//        int result = fish.solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0});

//        Nesting nesting = new Nesting();
//        int result = nesting.solution("(()(())())");

//        Dominator dominator = new Dominator();
//        int result = dominator.solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3});

//        FactoryFilters factoryFilters = new FactoryFilters();
//        int result = factoryFilters.solution(new int[]{3,0,5});



//        HillsAndValleys hillsAndValleys = new HillsAndValleys();
//        int result = hillsAndValleys.solution(new int[]{2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5});

//        StoneWall stoneWall = new StoneWall();
//        int result = stoneWall.solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 4});

//        Q1 q1 = new Q1();
//        int result = q1.solution(new int[]{3,2,-2,5,-3});
//        int result = q1.solution(new int[]{1,1,2,-1,2,-1});
//        int result = q1.solution(new int[]{1,2,3,-4});

//        CarSeats carSeats = new CarSeats();
//        int result = carSeats.solution(new int[]{2,3,4,2},new int[]{2,5,7,2});
//        int result = carSeats.solution(new int[]{1,4,1},new int[]{1,5,1});
//        int result = carSeats.solution(new int[]{},new int[]{1});

//        Q3 q3 = new Q3();
////        boolean result = q3.solution(4, new int[]{1,2,4,4,3},new int[]{2,3,1,3,1});
//        boolean result = q3.solution(4, new int[]{},new int[]{});

//        AABBAB aabbab = new AABBAB();
//        int result = aabbab.solution("BAABABB");

        char[][] A = {
                {'A', '.', '.', '.'},
                {'.', '.', '.', '^'},
                {'.', 'v', '.', '.'},
                {'.', '.', '.', '>'}
        };
        boolean result = PathFinder2.solution(A);

        System.out.println("Solution! \n -----------");
        System.out.println(result);
    }
}