/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation;

/**
 *
 * @author Nesrin
 */
public class DivisibleSumPairs {

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int x = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if((ar[j]+ ar[i])%k ==0)
                    x++;
            }
        }
        System.out.println(x);
        return x;
    }

    public static void main(String[] args) {
        int[] ar = {1, 3, 2, 6, 1, 2};
        divisibleSumPairs(6, 3, ar);
    }
}
