package org.example;

public class AABBAB {
    public int solution(String S) {
        int n = S.length();
        int countA = 0; // count of 'A' letters
        int countB = 0; // count of 'B' letters
        int res = n; // assume we delete all letters

        // count 'A' and 'B' letters
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'A') {
                countA++;
            } else {
                countB++;
            }
        }
        // try all possible positions to split the string
        int curA = 0; // count of 'A' letters before the current position
        int curB = 0; // count of 'B' letters after the current position
        System.out.println(S);
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'A') {
                curA++;
            } else {
                curB++;
            }
            res = Math.min(res, curB + countA - curA);
            System.out.println("index: "+i+" res: "+ res+" \n Number of Bs removed: "+ curB + "\n Number of As Removed: " + (countA - curA));
        }
        return res;
    }

}
