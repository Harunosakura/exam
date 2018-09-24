/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Nesrin
 */
public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] a) {
        long[] manipulatedArray = new long[n];
        long max = 0;
        // run the operations
        for (int[] a1 : a) {
            int s = a1[0] - 1;
            int e = a1[1]==n?-1: a1[1];
            int v = a1[2];
            if (v == 0) {
                continue;
            }
            // set the start and end value;
            manipulatedArray[s] += v;
            if(e!=-1)
                manipulatedArray[e] -= v;
        }
        // update with acual value;
        for (int i = 1; i < manipulatedArray.length; i++) {
            manipulatedArray[i] += manipulatedArray[i - 1];
            max =Math.max(max, manipulatedArray[i]);
        }
        return max;
    }

    static long arrayManipulation1(int n, int[][] a) {
        int[] manipulatedArray = new int[n];
        int max = 0;
        //    Arrays.fill(manipulatedArray, 0);
        for (int[] a1 : a) {
            int s = a1[0] - 1;
            int e = a1[1] - 1;
            int v = a1[2];
            if (v == 0) {
                continue;
            }
            for (int j = s; j <= e; j++) {
                manipulatedArray[j] += v;
                max = Math.max(max, manipulatedArray[j]);
            }
        }

//        for (int j = 0; j < manipulatedArray.length; j++) {
//            System.out.print(" " + manipulatedArray[j]);
//        }
System.out.println(max);
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\arr.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\result1.txt"));
        String[] nm = bufferedReader.readLine().trim().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = bufferedReader.readLine().trim().split(" ");
            //    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
    }

    public static void main1(String[] args) {
        int[][] a = {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}};
        int n = 5;
        arrayManipulation(n, a);
        //int[] a1 = {2 ,5, 1 ,3, 4};
        //0, 1, 4, 2, 6, 7, 5,, 3
        //0, 0, 2, 0, 2, 2,

        //System.out.println(a[0] & a[5]);
    }
}
