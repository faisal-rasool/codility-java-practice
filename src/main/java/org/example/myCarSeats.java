package org.example;

import java.util.Arrays;

public class myCarSeats {
    public int solution(int[] P, int[] S) {
        int totalPassengers = Arrays.stream(P).sum();
        int seats = 0;
        Arrays.sort(S);
        int carUsed = 0;
        for (int i=S.length-1;i>=0;i--){
            seats+=S[i];
            carUsed++;
            if(seats>=totalPassengers){
                return carUsed;
            }
        }
        return 0;
    }
}
