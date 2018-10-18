/*
https://www.hackerrank.com/contests/booking-hack-a-holiday/challenges/weekend-away
 */
package challenge.booking.citybreak;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 *
 * @author Nesrin
 */
public class WeekendAway {

         public static void main(String[] args) throws Exception {
//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                  BufferedReader bufferedReader
                          = new BufferedReader(new FileReader(new File("C:\\java\\wa1.txt")));

                  int testCases = Integer.parseInt(bufferedReader.readLine().trim());

//                           System.out.println("2 " + LocalDateTime.now());
                  IntStream.range(0, testCases).forEach(t -> {
                           Map<Integer, List<Integer>> locations = new LinkedHashMap<>();

                           try {
                                    String[] line2 = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                                    int numberOfLocations = Integer.parseInt(line2[0].replaceAll("\\s+$", ""));
                                    int numberOfRoads = Integer.parseInt(line2[1].replaceAll("\\s+$", ""));
                                    IntStream.range(0, numberOfRoads).forEach(i -> {
                                             try {

                                                      String[] ABD = bufferedReader.readLine().split(" ");
                                                      int A = Integer.parseInt(ABD[0].replaceAll("\\s+$", ""));
                                                      int B = Integer.parseInt(ABD[1].replaceAll("\\s+$", ""));
                                                      int D = Integer.parseInt(ABD[2].replaceAll("\\s+$", ""));
                                                      List<Integer> location = (locations.get(A) != null ? locations.get(A) : new ArrayList<>());
                                                      location.add(D);
                                                      locations.put(A, location);
                                                      List<Integer> location2 = (locations.get(B) != null ? locations.get(B) : new ArrayList<>());
                                                      location2.add(D);
                                                      locations.put(B, location2);
                                             } catch (IOException ex) {
                                                      throw new RuntimeException(ex);
                                             }
                                    });
//                                    System.out.println(t);
                                    long minimal_result = getResult(locations, numberOfLocations);

                                    System.out.println(minimal_result);
                           } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                           }
                  });
         }

         public static long getResult(Map<Integer, List<Integer>> locations, int numberOfLocations) {

                  Long minimal_result = Long.MAX_VALUE;
                  for (Map.Entry<Integer, List<Integer>> entry : locations.entrySet()) {
                           List<Integer> location = entry.getValue();
                           Integer dist_smallest = Integer.MAX_VALUE;
                           Integer dist_small = Integer.MAX_VALUE;
                           if (null == location || location.isEmpty() || location.size() < 2)
                                    continue;
                           else

                                    for (int dist : location)
                                             if (dist < dist_smallest) {
                                                      dist_small = dist_smallest;
                                                      dist_smallest = dist;
                                             } else if (dist < dist_small)
                                                      dist_small = dist;

                           long dist_total = dist_small + dist_smallest;
//                           System.out.println(i + "  " + dist_total);
                           if (dist_total < minimal_result)
                                    minimal_result = dist_total;
                  }

                  return minimal_result;
         }

}
