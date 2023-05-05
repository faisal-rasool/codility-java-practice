// O(N***)
package org.example;

public class MaxProductOfThree1 {
    public int solution(int[] A) {
        int maxProduct = Integer.MIN_VALUE;
        for(int x=0; x<A.length-2;x++){
            int y=x+1;
            int z=x+2;
//            int currentProduct = A[x]*A[y]*A[z];
//            maxProduct = Math.max(maxProduct,currentProduct);

            for(;y<A.length-1;y++) {
                z=y+1;
//                currentProduct = A[x]*A[y]*A[z];
//                maxProduct = Math.max(maxProduct,currentProduct);
                for(;z<A.length;z++) {
                    int currentProduct = A[x]*A[y]*A[z];
                    maxProduct = Math.max(maxProduct,currentProduct);
                }
            }
        }
        return maxProduct;
    }

}
