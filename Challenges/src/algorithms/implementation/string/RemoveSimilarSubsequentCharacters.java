/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation.string;

/**
 *
 * @author Nesrin
 */
public class RemoveSimilarSubsequentCharacters {
         
         //For each query, print the minimum number of deletions required on a new line.

    static int alternatingCharacters(String s) {
        char[] c =  s.toCharArray();
        StringBuilder sb= new StringBuilder();
        sb.append(c[0]);
        for(int i = 1; i < c.length; i++){
            if(c[i]!=c[i-1])
                sb.append(c[i]);
        }
        //System.out.println(c.length +" "+sb.length());
        return c.length-sb.length();
    }

}
