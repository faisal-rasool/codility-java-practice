package org.example;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne1 {
    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int t = 0; t < A.length; t++) {
            set.add(A[t]);
            if (set.size() == X) {
                return t;
            }
        }
        return -1;
    }
}
