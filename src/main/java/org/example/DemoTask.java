package org.example;

import java.util.Arrays;

public class DemoTask {
    //    https://app.codility.com/c/run/demoGCRJDT-3GV/
    public int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        int answer = 1;
        for(int i=0; i<A.length; i++) {
            if(A[i] > answer) {
                return answer;
            } else if(A[i] == answer) {
                answer++;
            }
        }
        return 0;
    }
}

