/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author Nesrin
 */
public class MorganAndAString {

    public static void main(String[] args) throws IOException {
//        morganAndString("JACK", "DANIEL");
        morganAndString("YZYYZYZYY", "ZYYZYZYY");
//        morganAndString("ABACABA", "ABACABA");
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\morgan.txt")));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\result1.txt"));
//        //bufferedReader.readLine().trim();
//        //  int t = scanner.nextInt();
//        System.out.println(LocalDateTime.now().toString());
//        BufferedReader readResult = new BufferedReader(new FileReader(new File("C:\\java\\morR.txt")));
//
//        for (int i = 0; i < 5; i++) {
//            String a = bufferedReader.readLine().trim();
//            String b = bufferedReader.readLine().trim();
//            String result = morganAndString(a, b);
//            String req = readResult.readLine().trim();
//            System.out.println(req.equals(result));
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
//            System.out.println(i+" Main");
//        }
//        System.out.println(LocalDateTime.now().toString());
//        bufferedWriter.close();

    }

    // Complete the morganAndString function below.
    static String morganAndString(String a, String b) {
//        if(a.equals(b))
//            return a+b;
        int aLength = a.toCharArray().length;
        int bLength = b.toCharArray().length;
        int maxlength = aLength + bLength;
        boolean aIsLast = false;
        boolean aIsGreater = false;
        int aLastComparedIndex = 0;
        int bLastComparedIndex = 0;
        //      int minlength = Math.min(aLength, bLength);
        int aIndex = 0;
        int bIndex = 0;
        //System.out.println(LocalDateTime.now().toString());

        char[] toCharArrayA = a.toCharArray();
        // System.out.println(LocalDateTime.now().toString());

        char[] toCharArrayB = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        // System.out.println(LocalDateTime.now().toString());

        while (aIndex< aLength && toCharArrayA[aIndex] <= toCharArrayB[bIndex]  ) {
            if (aIndex>=8190 && aIndex<8193) {
                System.out.println(aIndex);
            }
            sb.append(toCharArrayA[aIndex++]);
            
        }
        while (aIndex< aLength && bIndex< bLength && toCharArrayA[aIndex] > toCharArrayB[bIndex]  ) {
            sb.append(toCharArrayB[bIndex++]);
        }
        for (int i = 0; i < maxlength && aIndex< aLength &&bIndex< bLength; i++ ) {
            ////System.out.println(i+" "+sb.toString());
            if (toCharArrayA[aIndex] < toCharArrayB[bIndex]) {
                sb.append(toCharArrayA[aIndex++]);
                aIsLast = true;
                aLastComparedIndex = aIndex;

                //System.out.println("a : " + toCharArrayA[aIndex - 1]);
            } else if (toCharArrayA[aIndex] > toCharArrayB[bIndex]) {
                sb.append(toCharArrayB[bIndex++]);
                aIsLast = false;
                bLastComparedIndex = bIndex;
                //System.out.println("b : " + toCharArrayB[aIndex - 1]);
            } else {
                //System.out.println("c : " + aIsLast + " " + aIsGreater + " " + i);

                int flag = 0;
                if (aIsLast && !aIsGreater && bLastComparedIndex == bIndex && aLastComparedIndex != aIndex) {
                    sb.append(toCharArrayA[aIndex++]);
                    aIsLast = true;
                    aIsGreater = false;
                    aLastComparedIndex = aIndex;

                } else if (!aIsLast && aIsGreater && aLastComparedIndex == aIndex && bLastComparedIndex != bIndex) {
                    sb.append(toCharArrayB[bIndex++]);
                    aIsLast = false;
                    aIsGreater = true;
                    bLastComparedIndex = bIndex;
                } else {
                    flag = a.substring(aIndex).compareTo(b.substring(bIndex));
                    if (flag <= 0) {

                        sb.append(toCharArrayA[aIndex++]);
                        aIsLast = true;
                        aIsGreater = false;
                        aLastComparedIndex = aIndex;

                    } else {
                        sb.append(toCharArrayB[bIndex++]);
                        aIsLast = false;
                        aIsGreater = true;
                        bLastComparedIndex = bIndex;

                    }
                }

            }
            //System.out.println(LocalDateTime.now().toString());

            if (aIndex == aLength || bIndex == bLength) {
                break;
            }
            //System.out.println(sb.toString());
        }
        if (aIndex < aLength) {
            sb.append(a.substring(aIndex));
        } else {
            sb.append(b.substring(bIndex));
        }
//        System.out.println(sb.toString());
        //System.out.println("YZYYZYYZYZYYZYZYY");
        System.out.println("YZYYZYYZYZYYZYZYY".equals(sb.toString()));
        //System.out.println(LocalDateTime.now().toString());

        return sb.toString();

    }

}
