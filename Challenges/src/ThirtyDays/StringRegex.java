/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirtyDays;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nesrin
 */
public class StringRegex {

         public static void main(String[] args) {
                  int cnt = 0;
                  String str = "3232323232";
                  Pattern p = Pattern.compile("(\\d*?)32(\\d*?)");
                  Matcher m = p.matcher(str);
                  while(m.find()){
                           System.out.println(++cnt);
                  }
                String x =   m.replaceAll("-1");
                  System.out.println(str);
                  System.out.println(x);
         }
}
