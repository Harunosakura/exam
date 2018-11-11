/*
* https://www.hackerrank.com/contests/booking-womenintech/challenges/distance-between-two-polygons
 */
package challenge.booking.women2018.august;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Nesrin
 */
public class MinimumDisBTWConvexPolygon {

         static double distance(double x, double y, double x1, double y1, double x2, double y2) {

                  double a = x - x1;
                  double b = y - y1;
                  double c = x2 - x1;
                  double d = y2 - y1;

                  double dot = a * c + b * d;
                  double len_sq = c * c + d * d;
                  double param = -1;
                  if (len_sq != 0) //in case of 0 length line
                  
                           param = dot / len_sq;

                  double xx, yy;

                  if (param < 0) {
                           xx = x1;
                           yy = y1;
                  } else if (param > 1) {
                           xx = x2;
                           yy = y2;
                  } else {
                           xx = x1 + param * c;
                           yy = y1 + param * d;
                  }

                  double dx = x - xx;
                  double dy = y - yy;
                  return Math.sqrt(dx * dx + dy * dy);
         }

         static boolean isPointInsidePoly(int x, int y, List<List<Integer>> poly) {
                  boolean result = false;
                  for (int i = 0, j = poly.size() - 1; i < poly.size(); j = i++) {
                           double x1 = poly.get(i).get(0);
                           double x2 = poly.get(j).get(0);
                           double y1 = poly.get(i).get(1);
                           double y2 = poly.get(j).get(1);
                           if ((y1 > y) != (y2 > y) && (x < (x2 - x1) * (y - y1) / (y2 - y1) + x1))
                                    result = !result;
                  }
                  return result;
         }

         static double solve(List<List<Integer>> p, List<List<Integer>> q) {
                  for (int i = 0; i < p.size(); i++) {
                           int x = p.get(i).get(0);
                           int y = p.get(i).get(1);
                           if (isPointInsidePoly(x, y, q))
                                    return 0;
                  }

                  for (int i = 0; i < q.size(); i++) {
                           int x = q.get(i).get(0);
                           int y = q.get(i).get(1);
                           if (isPointInsidePoly(x, y, p))
                                    return 0;
                  }
                  double min = Double.MAX_VALUE;
                  for (int i = 0; i < p.size(); i++) {
                           int px = p.get(i).get(0);
                           int py = p.get(i).get(1);

                           int x1 = q.get(0).get(0);
                           int y1 = q.get(0).get(1);
                           for (int j = 0; j < q.size(); j++) {
                                    int newj = j + 1;
                                    if (newj == q.size())
                                             newj = 0;
                                    int x2 = q.get(newj).get(0);
                                    int y2 = q.get(newj).get(1);
                                    double dist = distance(px, py, x1, y1, x2, y2);
                                    min = Math.min(min, dist);

                                    x1 = x2;
                                    y1 = y2;
                           }
                  }
                  for (int i = 0; i < q.size(); i++) {
                           int px = q.get(i).get(0);
                           int py = q.get(i).get(1);

                           int x1 = p.get(0).get(0);
                           int y1 = p.get(0).get(1);
                           for (int j = 0; j < p.size(); j++) {

                                    int newj = j + 1;
                                    if (newj == p.size())
                                             newj = 0;
                                    int x2 = p.get(newj).get(0);
                                    int y2 = p.get(newj).get(1);
                                    double dist = distance(px, py, x1, y1, x2, y2);
                                    min = Math.min(min, dist);
                                    x1 = x2;
                                    y1 = y2;
                           }
                  }

                  return min;
         }

         public static void main(String[] args) throws IOException {
                  BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\len55.txt")));
                  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\result1.txt"));
                  String[] nm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                  int n = Integer.parseInt(nm[0]);

                  int m = Integer.parseInt(nm[1]);

                  List<List<Integer>> p = new ArrayList<>();

                  IntStream.range(0, n).forEach(i -> {
                           try {
                                    p.add(
                                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                                    .map(Integer::parseInt)
                                                    .collect(toList())
                                    );
                           } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                           }
                  });

                  List<List<Integer>> q = new ArrayList<>();

                  IntStream.range(0, m).forEach(i -> {
                           try {
                                    q.add(
                                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                                    .map(Integer::parseInt)
                                                    .collect(toList())
                                    );
                           } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                           }
                  });

                  double result = solve(p, q);
                  bufferedWriter.write(String.valueOf(result));
                  bufferedWriter.newLine();

                  bufferedReader.close();
                  bufferedWriter.close();
         }
}
