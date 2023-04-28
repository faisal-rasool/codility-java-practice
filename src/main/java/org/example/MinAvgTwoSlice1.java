package org.example;

import java.util.Arrays;

public class MinAvgTwoSlice1 {
    public int solution(int[] A) {
        int resultIndex=-1;
        double minAvg=Double.MAX_VALUE;


        for (int i=0; i<A.length;i++){

            for (int y=i+1; y<A.length; y++){

                int[] tmp = Arrays.copyOfRange(A,i,y+1);
//                float avg = Arrays.stream(tmp).sum()/tmp.length;
                double avg = Arrays.stream(tmp).average().getAsDouble();
//                System.out.println(i+" "+y+" "+avg);
               if( avg< minAvg){
                   minAvg=avg;
                   resultIndex=i;
               }
            }
        }
        return  resultIndex;
    }
}
