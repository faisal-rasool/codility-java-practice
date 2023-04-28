package org.example;

import java.util.Arrays;
import java.util.List;

public class TapeEquilibrium {
    public int solution(int[] A) {

        int left = A[0];
        int right = Arrays.stream(A).sum() - left;
        int diff = Math.abs( left-right);

        for (int i=1 ; i<A.length -1; i++) {
            left += A[i];
            right -= A[i];
            int innerDiff  = Math.abs(left-right);
            if(diff>innerDiff) diff = innerDiff;

        }
        return diff;
    }

}
