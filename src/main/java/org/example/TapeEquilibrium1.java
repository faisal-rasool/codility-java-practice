package org.example;

import java.util.Arrays;

public class TapeEquilibrium1 {
    public int solution(int[] A) {
        int[] differences = new int[A.length-1];
        for (int i=1 ; i<A.length; i++) {
            int[] start = Arrays.copyOfRange(A,0,i);
            int[] end = Arrays.copyOfRange(A, i,A.length);
            int diff = Math.abs(sum(start) - sum(end));
            differences[i-1] = diff;
            System.out.print("test");
        }
        Arrays.sort(differences);
        return differences[0];
    }
    private int sum(int[] A){
        int sum = 0;
        for(int x:A){
            sum=sum+x;
        }
        return sum;
    }

}
