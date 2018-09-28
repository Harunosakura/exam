/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation.string;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nesrin
 */
public class DistinctSubStringCount {

    static int[] countSubstrings(String s, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < queries[0].length; j++) {
                System.out.print(queries[i][j] + " ");
            }
            System.out.println();
        }
        return null;
    }

    public static void main(String[] args) {
        String text = "ababa";

        //List<String> list = new ArrayList<>();
        Map<String, Integer> list = new HashMap<>();
        int len = text.length();
        int counter = 0;
        for (int j = 0; j < len; j++) {
            for (int sub = 1; sub <= len - j; sub++) {
                String subPart = text.substring(j, j + sub);
                //  System.out.println(subPart);
                list.put(subPart, 0);
            }
        }
        System.out.println(list);
    }
}
