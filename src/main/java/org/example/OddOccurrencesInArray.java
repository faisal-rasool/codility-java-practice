package org.example;

import java.util.Arrays;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        Arrays.sort(A);
        for(int i=0; i< A.length; i++){
            if(i+1 >= A.length){
                return A[i];
            }
            if(A[i] == A[i+1]){
                ++i;
                continue;
            } else {
                return A[i];
            }
        }
        return -1;
    }
}
