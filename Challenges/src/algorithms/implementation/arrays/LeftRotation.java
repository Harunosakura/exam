/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Nesrin
 */
public class LeftRotation {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int d = 4;
        int[] res = new int[a.length];

        System.arraycopy(a, d, res, 0, a.length - d);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

        }
        System.arraycopy(a, 0, res, a.length - d, d);

        
        
        System.arraycopy(a, d, res, 0, a.length-d);
        System.arraycopy(a,0,res, a.length-d, d);
        
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

        }
    }
}
