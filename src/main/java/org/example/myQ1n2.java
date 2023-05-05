package org.example;

import java.util.Arrays;
public class myQ1n2 {
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i=0;i<A.length;i++){
            if (A[i] < 0 ){
                int x = Math.abs(A[i]);
                if (Arrays.stream(A).anyMatch(y -> y == x)){
                    return x;
                }
            }
        }
        return 0;
    }
}
