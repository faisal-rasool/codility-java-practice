package org.example;

public class BinaryGap {
        public int solution(int N) {
            // Implement your solution here
            int maxGap = 0;
            int gap= 0;
            String bs = Integer.toBinaryString(N);
            for(int i=0; i<bs.length();i++){
                if(bs.charAt(i) == '1'){
                    if(gap > maxGap) {
                        maxGap = gap;
                    }
                    gap=0;
                }else{
                    gap++;
                }
            }
            return maxGap;
        }
    }