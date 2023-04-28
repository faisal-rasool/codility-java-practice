package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Spliterator;

public class MinAvgTwoSlice {
    public int solution(int[] A) {
        int resultIndex = -1;
        double minAvg = (double)Integer.MAX_VALUE;

        for (int i = 0; i < A.length-1; i++) {
            double lastAvg  = (A[i]+A[i+1])/ 2;
            if (lastAvg < minAvg) {
                minAvg = lastAvg;
                resultIndex = i;
            }
            System.out.println(i+" "+ (i+1)+"  "+lastAvg);
            for (int y = i + 2; y < A.length; y++) {
                lastAvg = (lastAvg * (y-i) + A[y])/(y-i+1);
                if (lastAvg < minAvg) {
                    minAvg = lastAvg;
                    resultIndex = i;
                }
                System.out.println(i+" "+ y+"  "+lastAvg);
            }
        }
        return resultIndex;
    }
}
//        A[0] = 4
//        A[1] = 2
//        A[2] = 2
//        A[3] = 5
//        A[4] = 1
//        A[5] = 5
//        A[6] = 8