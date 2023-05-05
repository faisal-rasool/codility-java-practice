package org.example;

import netscape.security.UserTarget;

import java.util.Stack;

public class StoneWall {
    public int solution(int[] H) {
        int n = H.length;
        int blocks = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && H[i] < stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty() || H[i] > stack.peek()) {
                stack.push(H[i]);
                blocks++;
            }
        }
        return blocks;
    }
}