package org.example;

public class HillsAndValleys1 {
    public int solution(int[] A) { // [2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5].
        int[][] slices = new int[A.length][2];
        int sliceCounter = 0;
        slices[sliceCounter][0] = 0;
        int currentTerrain = A[0];


        for (int i = 1; i < A.length; i++) {
            if (A[i] != currentTerrain) {
                slices[sliceCounter][1] = i - 1;
                sliceCounter++;
                slices[sliceCounter][0] = i;
                currentTerrain = A[i];
            }
            if (i + 1 == A.length) {
                slices[sliceCounter][1] = i;
                sliceCounter++;
            }
        }

        for (int[] x : slices) {
            System.out.println("(" + x[0] + "," + x[1] + ")");

        }
        System.out.println("Slice Counter = " + sliceCounter);

        int result = 0;
        for (int i = 0; i < sliceCounter; i++) {
            if (isHillOrValley(slices[i], A)) {
                result++;
            }
        }
        return result;
    }

    private boolean isHillOrValley(int[] slice, int[] A) {
        int i = slice[0];
        int j = slice[1];

        if ((i == 0 || A[i] > A[i - 1]) && (j == A.length - 1 || A[j] > A[j + 1])) {
            return true;
        } else if ((i == 0 || A[i] < A[i - 1]) && (j == A.length - 1 || A[j] < A[j + 1])) {
            return true;
        }
        return false;
    }
}