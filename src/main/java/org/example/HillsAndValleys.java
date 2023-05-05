package org.example;

public class HillsAndValleys {
    public int solution(int[] A) {
        int N = A.length;
        if (N == 0) return 0;
        int count = 0;
        int prevValue = A[0];
        for(int idx = 1; idx < N - 1; idx++) {
            if(((A[idx] - prevValue) * (A[idx + 1] - A[idx])) < 0) {
                count++;
                prevValue = A[idx];
            }
        }
        if(count == 0){
            if(A[0] == A[N-1]) return 1;
            return 2;
        }
        return count + 2;
    }
}