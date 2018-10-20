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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Nesrin
 */
public class HappinessScore {

         static int counter;
         static List<Integer> lst = new ArrayList<>();
         static Set<Integer> uniqueSums = new HashSet<>();

         public static void main(String[] args) throws IOException {
//                  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                  BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\hs0.txt")));
                  String firstLine = bufferedReader.readLine().replaceAll("\\s+$", "");
                  String[] secondLine = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                  for (String str : secondLine)
                           lst.add(Integer.parseInt(str.replaceAll("\\s+$", "")));
                  solve();
                  System.out.println(counter);
         }

         static boolean isPrime(int num) {
                  if (num == 1)
                           return false;
                  else if (Math.abs(num) < 4)
                           return true;
                  else if (num % 2 == 0)
                           return false;
                  else {
                           //     int x =(int) Math.sqrt(num);
                           for (int j = 3; j * j <= num; j++)
                                    if (num % j == 0)
                                             return false;
                           return true;
                  }
         }

         static void solve() {
                  int n = lst.size();

                  // Run a loop for printing all 2^n 
                  // subsets one by obe 
                  for (int i = 0; i < (1 << n); i++) {
                           int sum = 0;
                           // Print current subset 
                           for (int j = 0; j < n; j++)

                                    // (1<<j) is a number with jth bit 1 
                                    // so when we 'and' them with the 
                                    // subset number we get which numbers 
                                    // are present in the subset and which 
                                    // are not 
                                    if ((i & (1 << j)) > 0) {
                                             sum += lst.get(j);
                                             uniqueSums.add(sum);
                                    }
                  }
                  for (Iterator<Integer> iterator = uniqueSums.iterator(); iterator.hasNext();){
                           int x = iterator.next();
//                           System.out.println(x);
                           if (isPrime(x))
                                    counter++;
                  }
         }
}
