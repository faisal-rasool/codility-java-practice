package org.example;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class PathFinder2 {

    private static int[][] B;
    private static int numRows;
    private static int numCol;
    private static int starti;
    private static int startj;

    public static boolean solution(char[][] A) {
        numRows = A.length;
        numCol = A[0].length;

        // Initializing B
        B = new int[numRows][numCol];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCol; j++) {
                if (A[i][j] != '.') {
                    B[i][j] = 1;
                }

                if (A[i][j] == 'A') {
                    B[i][j] = 0;
                    starti = i;
                    startj = j;
                }

                if (A[i][j] == 'v') {
                    int k = i + 1;
                    while (k < numRows && A[k][j] == '.') {
                        B[k][j] = 1;
                        k++;
                    }
                }

                if (A[i][j] == '^') {
                    int k = i - 1;
                    while (k >= 0 && A[k][j] == '.') {
                        B[k][j] = 1;
                        k--;
                    }
                }

                if (A[i][j] == '>') {
                    int k = j + 1;
                    while (k < numCol && A[i][k] == '.') {
                        B[i][k] = 1;
                        k++;
                    }
                }

                if (A[i][j] == '<') {
                    int k = j - 1;
                    while (k >= 0 && A[i][k] == '.') {
                        B[i][k] = 1;
                        k--;
                    }
                }
            }
        }

        return f(starti, startj, new HashSet<>());
    }

    private static boolean f(int i, int j, Set<Pair<Integer, Integer>> visited) {
        if (i < 0) return false;
        if (j < 0) return false;
        if (i >= numRows) return false;
        if (j >= numCol) return false;
        if (visited.contains(new Pair<>(i, j))) return false;
        if (B[i][j] == 1) return false;
        if (j == numCol - 1) return true;
        visited.add(new Pair<>(i, j));

        return f(i, j + 1, visited) ||
                f(i, j - 1, visited) ||
                f(i + 1, j, visited) ||
                f(i - 1, j, visited);
    }
}