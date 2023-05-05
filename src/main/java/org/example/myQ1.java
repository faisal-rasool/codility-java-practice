package org.example;

import java.util.HashSet;
import java.util.Set;

public class myQ1 {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        int maxK = 0;
        for(int i=0;i<A.length;i++){
            int val = A[i];
            if(set.contains(-val)){
                maxK = Math.max(maxK, Math.abs(val));
            }
            set.add(val);
        }
        return maxK;
    }
}