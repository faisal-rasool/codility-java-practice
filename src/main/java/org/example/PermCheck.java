package org.example;

import java.util.Arrays;

public class PermCheck {
    public int solution(int[] A) {

        if (A.length==0) return 0;
        Arrays.sort(A);

        int start = 1;
        for (int i=0; i<A.length; i++, start++){
            if(A[i] != start){
                return 0;
            }
        }
        return 1;
    }
}