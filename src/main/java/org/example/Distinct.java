package org.example;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public int solution(int[] A) {

        Set<Integer> distinctSet= new HashSet<Integer>();
        for (int a:A){
            distinctSet.add(a);
        }
        return distinctSet.size();
    }
}
