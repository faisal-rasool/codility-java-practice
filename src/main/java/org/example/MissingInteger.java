package org.example;

import java.util.Arrays;

public class MissingInteger {
    public int solution(int[] A) {
        Arrays.sort(A);
        int result = 1;
        for(int x:A){
            if (x>0 && x>result){
                return result;
            } else if(x==result){
                result++;
            }
        }
        return result;
    }
}
