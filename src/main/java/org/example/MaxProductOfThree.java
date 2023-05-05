package org.example;

import java.util.Arrays;

public class MaxProductOfThree {
    public int solution(int[] A) {
        Arrays.sort(A);
        // max_1 = 1st biggest * 2nd biggest * 3rd biggest
        int max_1 = A[A.length-1] * A[A.length-2] * A[A.length-3];

        // max_2 = 1st smallest * 2nd smallest * 1st biggest
        int max_2 = A[0] * A[1] * A[A.length-1];

        // take the maximum
        int max = Math.max(max_1, max_2);

        return max;
    }

}
