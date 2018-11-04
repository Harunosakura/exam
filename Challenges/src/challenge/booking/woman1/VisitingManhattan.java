/*
https://www.hackerrank.com/contests/booking-womenintech-2017/challenges/visiting-manhattan
 */
package challenge.booking.woman1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nesrin
 */
public class VisitingManhattan {

         public static void main(String[] args) throws Exception {

//                  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                  BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\vm9.txt")));
                  String[] analysis = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                  int landmarks = Integer.parseInt(analysis[2]);
                  int hotels = Integer.parseInt(analysis[3]);

                  int[][] lm = new int[landmarks][2];

                  for (int i = 0; i < landmarks; i++) {
                           String[] record = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                           lm[i][0] = Integer.parseInt(record[0]);
                           lm[i][1] = Integer.parseInt(record[1]);
                  }
                  long sumDistanceToEachLM = 0;
                  long minDistance = Integer.MAX_VALUE;
                  int currentHotelIndex = 0;
                  int savedMin = 0;
                  for (int i = 0; i < hotels; i++) {

                           String[] record = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                           currentHotelIndex++;
                           sumDistanceToEachLM = 0;
                           for (int j = 0; j < lm.length; j++){
                                    sumDistanceToEachLM += Math.abs(Integer.parseInt(record[0]) - lm[j][0]) 
                                            + Math.abs(Integer.parseInt(record[1]) - lm[j][1]);
                                    if(sumDistanceToEachLM > minDistance)
                                             break;
                           }
                           if (minDistance > sumDistanceToEachLM) {
                                    minDistance = sumDistanceToEachLM;
                                    savedMin = currentHotelIndex;
                           }
                  }
                  System.out.println(savedMin);
//                  solve(lm, h);
         }

         private static void solve(int[][] lm, int[][] h) {
                  long sumDistanceToEachLM = 0;
                  long minDistance = Integer.MAX_VALUE;
                  int currentHotelIndex = 0;
                  int savedMin = 0;
                  for (int i = 0; i < h.length; i++) {
                           currentHotelIndex++;
                           sumDistanceToEachLM = 0;
                           for (int j = 0; j < lm.length; j++)
                                    sumDistanceToEachLM += Math.abs(h[i][0] - lm[j][0]) + Math.abs(h[i][1] - lm[j][1]);
                           if (minDistance > sumDistanceToEachLM) {
                                    minDistance = sumDistanceToEachLM;
                                    savedMin = currentHotelIndex;
                           }

                  }
                  System.out.println(savedMin);
         }
}
/**
 * for (Integer h : hd) { sumDistanceToEachLM = 0; currentHotelIndex++; for
 * (Integer lm : lmd) sumDistanceToEachLM += Math.abs(h - lm); // if
 * (minDistance < sumDistanceToEachLM)
 * //                                             break;
 * System.out.println("C: " + currentHotelIndex + "Sum :" + sumDistanceToEachLM + " h: " + h);
 * if (minDistance > sumDistanceToEachLM) { minDistance = sumDistanceToEachLM;
 * savedMin = currentHotelIndex; } }
 */
