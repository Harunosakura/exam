/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.booking.backend2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/booking-passions-hacked-backend/challenges/good-memories
 * <strong>Sample Input</strong>
 * 2<br>
 * 3<br>
 * Red square,Colosseum<br>
 * Louvre,Red square<br>
 * Louvre<br>
 * 3<br>
 * Sacre Coeur,The Hermitage<br>
 * Stonehenge,Versailles<br>
 * <strong>Sample Output</strong><br>
 *
 * ORDER EXISTS<br>
 * ORDER VIOLATION<br>
 */
public class GoodMemoriesTopologicalSorting {

         public static void main(String[] args) {
                  Scanner s = new Scanner(System.in);
                  int n = s.nextInt();
                  s.nextLine();
                  List<String> lines = new ArrayList<>();
                  for (int i = 0; i < n; i++) {
                           lines = new ArrayList<>();
                           int linesCount = s.nextInt();
                           s.nextLine();
                           for (int l = 0; l < linesCount; l++) {
                                    String line = s.nextLine();
                                    lines.add(line);
                           }
                           if (orderExist(lines))
                                    System.out.println("ORDER EXISTS");
                           else
                                    System.out.println("ORDER VIOLATION");
                  }
         }

         private static boolean orderExist(List<String> lines) {
                  Map<String, List<String>> preceeded = new HashMap<>();
                  List<String> singleLine;
                  for (int line = 0; line < lines.size(); line++) {
                           String[] cities = lines.get(line).replace("\\s", "").split(",");
                           // limits functionality, better to create new list
                           //to keep retainall functiona and more
//                           singleLine = Arrays.asList(cities);
                           singleLine = new ArrayList<>(Arrays.asList(cities));
                           for (int i = singleLine.size() - 1; i >= 0; i--)
                                    if (line != 0) {
                                             List<String> savedCities = preceeded.get(singleLine.get(i));
                                             if (savedCities != null && !savedCities.isEmpty()) {
                                                 //     System.out.println("1: " + savedCities);
                                                      List<String> x = singleLine.subList(i + 1, singleLine.size());
                                                      List<String> r = new ArrayList<>(savedCities);
                                                      boolean retainAll = r.retainAll(x);
                                                     // System.out.println("2: " + r);
                                                      if (!r.isEmpty())
                                                               return false;
                                             } else
                                                      preceeded.put(singleLine.get(i), singleLine.subList(0, i));

                                    } else
                                             preceeded.put(singleLine.get(i), singleLine.subList(0, i));
                  }

                  return true;
         }

}
