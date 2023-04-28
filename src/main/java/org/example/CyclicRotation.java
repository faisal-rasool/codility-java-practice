package org.example;

import java.util.Arrays;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {

        if(A.length == 0 || K==A.length) {
            return A;
        } else if (K > A.length) {
            K=K%A.length;
        }

        int[] result = new int[A.length];
        int rIndex=0;
        for(int i=0; i<K ;i++)
        {
            result[K-i-1]  = A[A.length-i-1];
        }
        for(int i=0; i<A.length-K;i++) {
            result[K+i] = A[i];
        }
        return result;
    }

}
