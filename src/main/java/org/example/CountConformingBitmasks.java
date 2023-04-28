package org.example;

import java.util.HashSet;
import java.util.Set;

public class CountConformingBitmasks {
    Set<String> generated_integers = new HashSet<>();

    public int solution(int A) {
        // Convert A, B, C to binary strings
        String bin_A = Integer.toBinaryString(A);
//        String bin_A = String.format("%30s", Integer.toBinaryString(A)).replace(' ', '0');
//        String bin_B = String.format("%30s", Integer.toBinaryString(B)).replace(' ', '0');
//        String bin_C = String.format("%30s", Integer.toBinaryString(C)).replace(' ', '0');

        // Initialize a set to store the generated integers

//        generated_integers.add(bin_A);
//        generated_integers.add(bin_B);
//        generated_integers.add(bin_C);


        testFn(-1, toArray(bin_A));
//        testFn(0,toArray( bin_B));
//        testFn(0,toArray( bin_C));
        return generated_integers.size();

    }

    private void testFn(int fixIndex, char[] arr) {
        generated_integers.add(new String(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0' && i != fixIndex) {
                arr[i] = '1';
                testFn(i, arr);
            }
        }
    }

    private char[] toArray(String binString) {
        char[] arr = new char[binString.length()];
        for (int i = 0; i < binString.length(); i++) {
            arr[i] = binString.charAt(i);

        }
        return arr;
    }

}
