package org.example;

public class FrogJmp {
    public int solution(int X, int Y, int D) {
        if (X == Y) return 0;


        int jumps = (Y - X) / D;
        if ((Y - X) % D == 0) {
            return jumps;
        } else {
            return ++jumps;
        }

// performance test failing
//        int jumps = 0;
//        for(;X<Y;jumps++){
//            X=X+D;
//        }
//        return jumps;
    }
}
