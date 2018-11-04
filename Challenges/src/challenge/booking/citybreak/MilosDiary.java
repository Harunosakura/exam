/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.booking.citybreak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Nesrin
 */
public class MilosDiary {

         static List<Integer> lst = new ArrayList<>();
//         static List<Integer> lstOrdered = new ArrayList<>();
         static Map<Integer, Integer> numberSet = new HashMap<>();

         public static void main(String[] args) throws IOException {
//                  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                  BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\hs0.txt")));
                  int firstLine = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));
                  if (firstLine < 1) {
                           // Exit early if we have no numbers or we have only 1, in both cases, this is a correct diary
                           System.out.println("YES");
                           return;
                  }
                  String[] secondLine = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                  solve(secondLine);
//                  System.out.println(counter);
         }

         static void solve(String[] nums) {
                  int lastNum = 0;
                  int maxNum = 0;

                  List<Integer> missed = new ArrayList<>();
                  missed.add(0);
                  int missedSize = 0;
//                  System.out.println("F: " + LocalDateTime.now().toString());
                  for (String str : nums) {
                           int currentNum = Integer.parseInt(str);
                           if (missed.contains(currentNum)) {
                                    Integer removed = missed.remove(missed.indexOf(currentNum));
                                    if (removed > 0)
                                             missedSize--;
                           }
//                           System.out.println("C: " + currentNum + " M: " + maxNum + " S: " + lastNum + " L: " + missed);
                           if (currentNum - maxNum > 1)
                                    for (int i = maxNum + 1; i < currentNum; i++) {
                                             missed.add(i);
                                             missedSize++;
                                    }
                           else if (missed.get(missedSize) > currentNum) {
                                    System.out.println("NO");
                                    return;
                           }
                           maxNum = Math.max(Math.max(Math.max(missed.get(missedSize), currentNum), lastNum), maxNum);
                           lastNum = currentNum;
                  }
//                  System.out.println("L : " + LocalDateTime.now().toString());

                  System.out.println("YES");

         }

         private static boolean numberSetCheck(Map<Integer, Integer> numberSet, int nextNumber, int lastNumber) {
                  // Check that all numbers between nextNumber and lastNumber are filled in to the set
                  for (int i = nextNumber + 1; i < lastNumber; i++)
                           if (numberSet.get(i) == null)
                                    return false;
                  return true;
         }
}
