/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirtyDays;

/**
 *
 * @author Nesrin
 */
public class Initializing {

         public static void main(String[] args) {
                  for (int i = 0; i < 10; i++) {
                           System.out.print(" 1 << " + i + " " + (1 << i));
                           System.out.print(" 2 << " + i + " " + (2 << i));
                           System.out.print(" 3 << " + i + " " + (3 << i));
                           System.out.println("");
                  }
                  for (int i = 0; i < 10; i++) {
                           System.out.println("----------------- " + i);

                           System.out.println(i | 1);
                           System.out.println(i | 2);
                           System.out.println(i | 3);
                           System.out.println(i | 4);
                           System.out.println(i | 5);
                  }
                    for (int i = 0; i < 10; i++) {
                           System.out.println("----------------- " + i);

                           System.out.println(i & 1);
                           System.out.println(i & 2);
                           System.out.println(i & 3);
                  }
//                  for (int i = 0; i < (1 << 10); i++) {
         }
}
