package org.example;

public class CountDiv {
    public int solution(int A, int B, int K) {
        int x = 0;
        while (A <= B) {
            if (A % K == 0) {
                x = B/K;
                x++;
                A += K;
            } else if(A>K) {
                A+=K-A%K;
            }else {
                A++;
            }
        }
        return x;
    }
}
