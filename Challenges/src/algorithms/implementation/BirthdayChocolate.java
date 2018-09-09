/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nesrin
 */
public class BirthdayChocolate {
    
    static int birthday(List<Integer> s, int d, int m) {
        int x = 0;
        int sum =0;
        for (int i = 0; i < s.size()-m+1; i++) {
            sum =0;
            for (int j = 0; j < m; j++) {
                sum+=s.get(i+j);
            }
            if(sum ==d)
                x++;
        }
       // System.out.println(x);
        return x;
    }

    public static void main(String[] args) {
       List<Integer> cho = new ArrayList<>();
       cho.add(4);
       cho.add(2);
       cho.add(1);
       cho.add(3);
       cho.add(2);
       cho.add(2);
        birthday(cho, 4, 2);
    }
}
