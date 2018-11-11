/*
 * https://www.hackerrank.com/contests/booking-womenintech/challenges/morph-search-results
 */
package challenge.booking.women2018.august;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class DynamicSearchResultsPerformanceTuned {

//    static List<Integer> indices = null;
         // Complete the solve function below.
         static int solve(List<Integer> list1, List<Integer> list2) {

                  if (list1.equals(list2))
                           return 0;

                  int list1size = list1.size();
                  int list2size = list2.size();
                  int movements = 0;

                  System.out.println("1- " + LocalDateTime.now().toString());

                  Map<Integer, Integer> keyList1 = new HashMap<>();
                  for (int i = 0; i < list1size; i++)
                           keyList1.put(list1.get(i), i);
                  System.out.println("2- " + LocalDateTime.now().toString());
                  List<Integer> ar = new ArrayList<>();
                  for (int i = 0; i < list2size; i++) {
                           Integer x = keyList1.get(list2.get(i));
                           if (x != null)
                                    ar.add(x);
                  }
                  System.out.println("3- " + LocalDateTime.now().toString());

                  int lis = longestIncreasingSubsequenceLength(ar, ar.size());
                  movements += (ar.size() - lis);
                  System.out.println("4- " + LocalDateTime.now().toString());

                  if (ar.size() < list1size) {
                           movements += (list1size - ar.size());
                           System.out.println("Remove : " + movements);
                  }
                  if (ar.size() < list2size) {
                           movements += (list2size - ar.size());
                           System.out.println("Add : " + movements);

                  }
                  System.out.println("5- " + LocalDateTime.now().toString());
                  System.out.println("movements = " + movements);
                  return movements;
         }
         // Binary search (note boundaries in the caller) 
         // A[] is ceilIndex in the caller 

         static int ceilIndex(int ar[], int l, int r, int key) {
                  System.out.println("ss");
                  while (r - l > 1) {
                           int m = l + (r - l) / 2;
                           if (ar[m] >= key)
                                    r = m;
                           else
                                    l = m;
                  }

                  return r;
         }

         static int longestIncreasingSubsequenceLength(List<Integer> ar, int size) {
                  int[] tailTable = new int[size];
                  int currentLlen; // always points empty slot 

                  tailTable[0] = ar.get(0);
                  currentLlen = 1;
                  for (int i = 1; i < size; i++)
                           if (ar.get(i) < tailTable[0]) // new smallest value 
                           
                                    tailTable[0] = ar.get(i);
                           else if (ar.get(i) > tailTable[currentLlen - 1]) // A[i] wants to extend largest subsequence 
                           
                                    tailTable[currentLlen++] = ar.get(i);
                           else // A[i] wants to be current end candidate of an existing 
                           // subsequence. It will replace ceil value in tailTable 
                           
                                    tailTable[ceilIndex(tailTable, -1, currentLlen - 1, ar.get(i))] = ar.get(i);
                  return currentLlen;
         }

         public static int increasingSubsequence(List<Integer> arr) {
                  List<List<Integer>> lis = new ArrayList<>();

                  System.out.println("5-a " + LocalDateTime.now().toString());
                  int max = arr.size();
                  int start = 0;
                  int end = 0;

                  for (int i = 1; i < end; i++) {
                           for (int j = 0; j < i; j++)
                                    if (arr.get(i) > arr.get(j) && lis.get(i).size() < lis.get(j).size() + 1)
                                             lis.set(i, new ArrayList<>(lis.get(j)));
                           lis.get(i).add(arr.get(i));
                  }
                  System.out.println("5-b" + LocalDateTime.now().toString());

                  List<Integer> longest = lis.get(0);
                  for (int i = 0; i < lis.size(); i++)
                           if (longest.size() < lis.get(i).size())
                                    longest = new ArrayList<>(lis.get(i));
                  System.out.println("5-c" + LocalDateTime.now().toString());

                  return longest.size();
         }

         public static void main(String[] args) throws IOException {
                  BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\list0.txt")));
                  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\result1.txt"));
                  String[] nm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                  int n = Integer.parseInt(nm[0]);
                  if (n < 1 || n > 200000)
                           throw new RuntimeException("Number Range Exception");
                  int m = Integer.parseInt(nm[1]);
                  if (m < 1 || m > 200000)
                           throw new RuntimeException("Number Range Exception");
                  List<Integer> list1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                          .map(Integer::parseInt)
                          .collect(toList());

                  List<Integer> list2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                          .map(Integer::parseInt)
                          .collect(toList());
//        list1 = new ArrayList<>();
//        list2 = new ArrayList<>();
//        for (int i = 0; i < 1000000; i+=10) {
//            list1.add(i);
//        }
//         for (int i = 0; i < 1000000; i+=11) {
//            list2.add(i);
//        }
//        Collections.sort(list2, Collections.reverseOrder());
                  int result = solve(list1, list2);

                  bufferedWriter.write(String.valueOf(result));
                  bufferedWriter.newLine();

                  bufferedReader.close();
                  bufferedWriter.close();
         }
}
