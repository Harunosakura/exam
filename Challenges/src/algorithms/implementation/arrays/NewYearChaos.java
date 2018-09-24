/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation.arrays;

/**
 *
 * @author Nesrin
 */
public class NewYearChaos {

    static void minimumBribes(int[] q) {
//        int n = q.length;
//
//        int swaps = 0;
//        for (int i = 0; i < n; i++) {
//            if ((q[i] - (i + 1)) > 2) {
//                System.out.println("Too chaotic");
//                return;
//            }
//            for (int j = i + 1; j < n; j++) {
//                if (q[i] > q[j]) {
//                    int tmp = q[j];
//                    q[j] = q[i];
//                    q[i] = tmp;
//                    swaps++;
//                }
//            }
//        }
//
//        System.out.println(swaps);
//        //    return min;

        int count = 0;
        for (int i = (q.length - 1); i >= 0; i--) {
//            if ((q[i] - 3) > i) {
//                System.out.println("Too chaotic");
//                return;
//            }
System.out.println("q[i] : "+q[i]);
System.out.println("q[i] - 2: " + (q[i] - 2));
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) {
                    count++;
                }
            }

        }
        System.out.println(count);

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 3, 7, 8, 6, 4};
        //int[] a1 = {2 ,5, 1 ,3, 4};
        //0, 1, 4, 2, 6, 7, 5, 3
        //0, 0, 2, 0, 2, 2,

        //System.out.println(a[0] & a[5]);
        minimumBribes(a);
 //       minimumBribes(a1);
    }

}
