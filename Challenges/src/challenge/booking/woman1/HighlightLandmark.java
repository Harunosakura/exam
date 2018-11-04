/*
https://www.hackerrank.com/contests/booking-womenintech-2017/challenges/highlight-landmarks
 */
package challenge.booking.woman1;

import java.util.Scanner;

/**
 *
 * @author Nesrin
 */
public class HighlightLandmark {

         /**
          * bookingcom the world leader in connecting travellers with awesome
          * places to stay has brought you the inside scoop of all the glitz and
          * glam of hollywood stroll down sunset boulevard hike to the hollywood
          * sign stand with the stars and sample the joy of jazz music so that
          * you can truly immerse yourself in all things la la land 3 hollywood
          * boulevard losangeles
          */
         public static void main(String args[]) throws Exception {
                  /* Enter your code here. Read input from STDIN. Print output to STDOUT */
                  Scanner s = new Scanner(System.in);
                  String desc = s.nextLine();
                  int cnt = s.nextInt();
                  s.nextLine();
                  String[] hightliht = s.nextLine().split(" ");
                  //  System.out.println(hightliht[0]);
                  //System.out.println(hightliht[0]+ hightliht[1]+hightliht[2]);
                  for (String hightliht1 : hightliht)
                           desc = desc.replaceAll("\\b" + hightliht1 + "\\b", " <b>" + hightliht1 + "</b> ");
                  System.out.println(desc);

         }

}
