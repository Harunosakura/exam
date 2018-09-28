/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.booking.woman1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Nesrin
 */
public class EmailEverywhere {

         public static void main(String[] args) {

                  Scanner s = new Scanner(System.in);
                  List<String> emails = new ArrayList<>();
                  List<Integer> priopities = new ArrayList<>();
                  int cnt = s.nextInt();
                  s.nextLine();
                  for (int i = 0; i < cnt; i++) {
                           String[] record = s.nextLine().split(" ");
                           if (record.length == 3) {
                                    int priority = Integer.parseInt(record[2]);
                                    emails.add(record[1]);
                                    priopities.add(priority);
                           } else {
                                    emails.add(record[0]);
                                    priopities.add(-1);
                           }
                  }
                  int currentIndex = 0;
                  do {
                           if (priopities.get(currentIndex) == -1)
                                    if (currentIndex == 0) {
                                             System.out.println("-1");
                                             priopities.remove(priopities.get(0));
                                             emails.remove(emails.get(0));

                                    } else {
                                             int indexTobeRemoved = calculateNextEmail(currentIndex, emails.subList(0, currentIndex + 1), priopities.subList(0, currentIndex + 1));
                                             priopities.remove(priopities.get(currentIndex));
                                             emails.remove(emails.get(currentIndex));
                                             priopities.remove(priopities.get(indexTobeRemoved));
                                             emails.remove(emails.get(indexTobeRemoved));
                                             currentIndex -= 2;
                                    }
                           currentIndex++;
                  } while (priopities.size() > 0);
         }

         private static int calculateNextEmail(int i, List<String> emails, List<Integer> priopities) {
                  List<Integer> sortedPrioriy = new ArrayList<>(priopities);
                  Collections.sort(sortedPrioriy, Collections.reverseOrder());
                  int indexOf = priopities.indexOf(sortedPrioriy.get(0));
                  System.out.println(emails.get(indexOf));
                  return indexOf;

         }

}
