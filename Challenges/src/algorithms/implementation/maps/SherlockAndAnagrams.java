/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation.maps;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nesrin
 */
public class SherlockAndAnagrams {

    public static void main(String[] args) {

        String text = "ifai";
        List<String> list = new ArrayList<>();
        int len = text.length();
        int counter = 0;
        for (int j = 0; j < len; j++) {
            for (int sub = 1; sub <= len - j; sub++) {
                String subPart = text.substring(j, j + sub);
              //  System.out.println(subPart);
                list.add(subPart);
            }
        }
      //  System.out.println("----------------");
        for (int j = 0; j < list.size(); j++) {
            String element = list.get(j);
            for (int k = j + 1; k < list.size(); k++) {
                if (isAnagram(list.get(k), element)) {
                    //System.out.println(list.get(k) + "->" + element);
                    counter++;
                }
            }
        }
        System.out.println(counter);

    }

    public static boolean isAnagram(String a, String b) {
        //System.out.println("a:"+a+" b:"+b);
        if (a.length() != b.length()) {
            return false;
        }
        int[] lettermap = new int[26];
        for (int j = 0; j < a.length(); j++) {
            char ch = a.charAt(j);
            //System.out.println("x"+lettermap[ch - 'a']);
//            System.out.println("x"+lettermap[ch]);
            lettermap[ch - 'a']++;
            ch = b.charAt(j);
            lettermap[ch - 'a']--;
        }

        for (int j = 0; j < lettermap.length; j++) {
            //System.out.println(lettermap[j]);
            if (lettermap[j] != 0) {
                return false;
            }
        }
        return true;
    }
}
