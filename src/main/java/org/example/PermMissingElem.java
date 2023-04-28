package org.example;

import java.util.Arrays;

public class PermMissingElem {
    public int solution(int[] A) {
        if(A.length ==0) return 1;
        Arrays.sort(A);

        int missingInt = 1;
        for (int i=0 ; i<A.length;i++){
            if(A[i] > missingInt){
                return missingInt;
            } else {
                missingInt++;
            }
        }
        return missingInt;
    }
}
