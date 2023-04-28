// TODO: 28/4/2023 Timeout error O(N**2)
package org.example;

public class PassingCars1 {
    public int solution(int[] A) {
        int zeroCounter = 0;
        int passingCars = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zeroCounter++;
            } else {
                passingCars+=zeroCounter;
                if (passingCars > 1000000000) return -1;
            }
        }

        return passingCars;
    }
}