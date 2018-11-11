/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Nesrin
 */
public class GradingStudents {

         /**
          * https://www.hackerrank.com/challenges/grading/problem
          */
         static int[] gradingStudents(int[] grades) {
                  int[] res = new int[grades.length];
                  for (int i = 0; i < grades.length; i++) {
                           int c = grades[i] + (5 - grades[i] % 5);
                           res[i] = c < 40 ? grades[i] : c - grades[i] >= 3 ? grades[i] : c;
                  }

                  return res;
         }

         /**
          * https://www.hackerrank.com/challenges/apple-and-orange/problem?h_r=next-challenge&h_v=zen
          */
         static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
                  int appCount = 0;
                  int orgCount = 0;
                  for (int i = 0; i < apples.length; i++)
                           if (apples[i] + a >= s && apples[i] + a <= t)
                                    appCount++;
                  System.out.println(appCount);
                  for (int i = 0; i < oranges.length; i++)
                           if (oranges[i] + b <= t && oranges[i] + b >= s)
                                    orgCount++;
                  System.out.println(orgCount);

         }

         /**
          * https://www.hackerrank.com/challenges/kangaroo/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
          */
         static String kangaroo(int x1, int v1, int x2, int v2) {
                  if ((v1 >= v2 && x1 > x2)
                          || (v2 >= v1 && x2 > x1))
                           return "NO";
                  else if ((v1 != v2) && ((x2 - x1) % (v1 - v2)) == 0)
                           return "YES";
                  else
                           return "NO";
         }

         /**
          * https://www.hackerrank.com/challenges/cavity-map/problem
          */
         static String[] cavityMap(String[] grid) {
                  for (int i = 1; i < grid.length - 1; i++) {
                           char[] width = grid[i].toCharArray();

                           for (int j = 1; j < width.length - 1; j++) {
                                    int counterW = 0;
                                    int counterL = 0;
                                    int prev = width[j - 1];
                                    int next = width[j + 1];
                                    int abv = grid[i - 1].charAt(j);
                                    int blw = grid[i + 1].charAt(j);
                                    int curr = width[j];
                                    if (curr > next)
                                             counterW++;
                                    if (curr > prev)
                                             counterW++;
                                    if (curr > abv)
                                             counterW++;
                                    if (curr > blw)
                                             counterW++;
                                    if (counterW == 4)
                                             grid[i] = grid[i].substring(0, j) + "X" + grid[i].substring(j + 1);
                           }
                  }
                  return grid;
         }


         public static void main(String[] args) throws Exception {
//                  int[] grades = gradingStudents(grades);
                  BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\gs.txt")));
                  int n = Integer.parseInt(bufferedReader.readLine());
                  String[] grid = new String[n];

                  for (int i = 0; i < n; i++) {
                           String gridItem = bufferedReader.readLine();
                           grid[i] = gridItem;
                  }

                  String[] result = cavityMap(grid);
         }
}
