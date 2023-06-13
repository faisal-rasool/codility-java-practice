package org.example;

import java.util.HashSet;

public class PathFinder {

    public static boolean solution(char[][] A) {

        int numRows = A.length;
        int numColumns = A[0].length;

        int starti = -1;
        int startj = -1;

        // initializing a
        boolean[][] B = new boolean[numRows][numColumns];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (A[i][j] != '.') {
                    B[i][j] = true;
                }

                if (A[i][j] == 'A') {
                    B[i][j] = false;
                    starti = i;
                    startj = j;
                }

                if (A[i][j] == 'v') {
                    int k = i+1;
                    while (k < numRows && A[k][j] == '.') {
                        B[k][j] = true;
                        k++;
                    }
                }

                if (A[i][j] == '^') {
                    int k = i-1;
                    while (k >= 0 && A[k][j] == '.') {
                        B[k][j] = true;
                        k--;
                    }
                }

                if (A[i][j] == '>') {
                    int k = j+1;
                    while (k < numColumns && A[i][k] == '.') {
                        B[i][k] = true;
                        k++;
                    }
                }

                if (A[i][j] == '<') {
                    int k = j-1;
                    while (k >= 0 && A[i][k] == '.') {
                        B[i][k] = true;
                        k--;
                    }
                }
            }
        }

        return f(starti, startj, numRows, numColumns, new HashSet<String>(),B);
    }

    public static boolean f(int i, int j, int numRows, int numColumns, HashSet<String> visited, boolean[][] B) {
        if (i < 0) return false;
        if (j < 0) return false;
        if (i >= numRows) return false;
        if (j >= numColumns) return false;
//        if (visited.contains([i, j])){
//            return false;
//        }
        if (B[i][j]) return false;
        if (j == numColumns-1) return true; //watch out

        visited.add(i + "," + j);
        return f(i, j+1,numRows,numColumns, visited,B) ||
                f(i, j-1, numRows,numColumns, visited,B) ||
                f(i+1, j, numRows,numColumns, visited,B) ||
                f(i-1, j, numRows,numColumns, visited,B);
    }
}
