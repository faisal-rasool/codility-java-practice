package org.example;

public class FrogRiverOne {
    public int solution(int X, int[] A) {
        int resultTime = -1;
        for(int i=1;i<X+1;i++){
            boolean found = false;
            for(int t=0; t<A.length;t++){

                if(A[t]==i){
                    if(t>resultTime) {
                        resultTime = t;
                    }
                    found = true;
                    break;
                }
            }
            if (!found){
                return -1;
            }
        }
        return resultTime;
    }
}