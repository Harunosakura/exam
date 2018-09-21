/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirtyDays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nesrin
 */
public class IsPrime {

    static boolean isPrime(int num) {
        if(num==1){
            System.out.println("Not prime");
            return false;
        } else if (Math.abs(num) < 4) {
            System.out.println("Prime");
            return true;
        } else if (num % 2 == 0) {
            System.out.println("Not prime");
            return false;
        } else {
            //     int x =(int) Math.sqrt(num);
            for (int j = 3; j*j <= num; j++) {
                if (num % j == 0) {
                    System.out.println("Not prime");
                    return false;
                }
            }
            System.out.println("Prime");
             return true;
        }
        // System.out.println("Prime");
        // System.out.println("Prime");

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < testCases; i++) {
            l.add(input.nextInt());
        }
        l.forEach(i -> isPrime(i));
    }
}
