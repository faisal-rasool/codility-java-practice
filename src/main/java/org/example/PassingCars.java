// TODO: 28/4/2023 Timeout error O(N**2)
package org.example;

public class PassingCars {
    public int solution(int[] A) {
        int passingCars = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                for (int y = i + 1; y < A.length; y++) {
                    if (A[y] == 1) {
//                        System.out.println("("+i+","+y+")");
                        passingCars++;
                    }
                }
            }
        }
        if (passingCars > 1000000000) return -1;
        return passingCars;
    }
}