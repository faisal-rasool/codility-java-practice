package org.example;

public class CountDiv1 {
    public int solution(int A, int B, int K) {
        int x =0;
        while (A<=B){
            if(A%K==0) x++;
            A++;
        }
        return x;
    }
}
