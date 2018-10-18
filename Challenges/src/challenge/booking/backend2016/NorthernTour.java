/*
https://www.hackerrank.com/contests/booking-passions-hacked-backend/challenges/lottery-ii
https://www.geeksforgeeks.org/maximum-bipartite-matching/
 */
package challenge.booking.backend2016;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 *
 * The first line contains an integer, , denoting the number of cities in the
 * list. Each line of the subsequent lines describes a city in the form of two
 * comma-separated values, (the city name) and (the minimum amount of time you
 * must spend visiting it). The next line contains a single integer, , denoting
 * the number of connections. Each of the subsequent lines describes a
 * bidirectional connection between two cities in the form of three
 * comma-separated values. The first two values are strings, and , describing a
 * bidirectional connection between cities and ; the third value is an integer,
 * , describing the number of hours needed to travel between the two cities.<br>
 * Output Format<br>
 *
 * Print your itinerary as a list of city names in the order in which you plan
 * to visit them. Each city name must be printed on a new line; if there is no
 * solution satisfying the criteria above, print NONE instead.
 *
 * <br>
 *
 * <strong>Sample Input</strong><br>
 *
 * 4<br>
 * Roma,38<br>
 * Florence,10<br>
 * Perugia,12<br>
 * Ancona,12<br>
 * 4
 * Bevagna,Roma,14<br>
 * Bevagna,Perugia,1<br>
 * Roma,Florence,4<br>
 * Roma,Perugia,2<br>
 */
public class NorthernTour {

         static Map<String, Integer> enjoyingCity = new HashMap<>();
         static final String START_POINT = "Bevagna";
         static Map<String, List<String>> connectedCitiesName = new HashMap<>();
         static Map<String, List<Integer>> travellingTime = new HashMap<>();
         static List<String> visitedCities = new ArrayList<>();
         static int allowedTime = 16;
         static int allowedDay = 6;

         public static void main(String[] args) throws Exception {
                  //                  System.out.println("1 " + LocalDateTime.now());
//                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                  enjoyingCity.put(START_POINT, 0);
                  BufferedReader bufferedReader
                          = new BufferedReader(new FileReader(new File("C:\\java\\nt4.txt")));
                  int t = Integer.parseInt(bufferedReader.readLine().trim());
//                           System.out.println("2 " + LocalDateTime.now());

                  IntStream.range(0, t).forEach(i -> {
                           try {
                                    String[] x = bufferedReader.readLine().split(",");
                                    enjoyingCity.put(x[0].replaceAll("\\s+$", ""),
                                            Integer.parseInt(x[1].replaceAll("\\s+$", "")));

                           } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                           }
                  });

//                                    System.out.println("3 " + LocalDateTime.now());
                  t = Integer.parseInt(bufferedReader.readLine().trim());
                  IntStream.range(0, t).forEach(i -> {
                           try {

                                    String[] x = bufferedReader.readLine().replaceAll("\\s+$", "").split(",");
                                    collectTravellingPreferences(x, 0);
                                    collectTravellingPreferences(x, 1);

                           } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                           }
                  });
                  visitedCities.add(START_POINT);
                  solve(visitedCities.get(0));
                  visitedCities.remove(0);
                  if (visitedCities.isEmpty())
                           System.out.println("NONE");
                  else
                           for (String visitedCity : visitedCities)
                                    System.out.println(visitedCity);
//                  System.out.println(visitedCities);
//                                    System.out.println("4 " + LocalDateTime.now());
         }

         private static void solve(String lastCity) {

                  List<Integer> list = travellingTime.get(lastCity);
                  List<String> cities = connectedCitiesName.get(lastCity);
                  if (list==null || list.isEmpty())
                           return;
                  for (int i = 0; i < list.size(); i++)
                           if (visitedCities.contains(cities.get(i))) {
                                    cities.remove(cities.get(i));
                                    list.remove(list.get(i));
                           }
                  if (list.isEmpty())
                           return;
                  
                  int minIndex = list.indexOf(Collections.min(list));
                  int minDistance = list.get(minIndex);
                  String minDistCityName = cities.get(minIndex);
                  int minStayTime = Integer.MAX_VALUE;
                  String minStayCityName = "";
                  for (String city : cities)
                           if (enjoyingCity.get(city) < minStayTime) {
                                    minStayTime = enjoyingCity.get(city);
                                    minStayCityName = city;
                           }
                  int minStayVal = minStayTime + list.get(cities.indexOf(minStayCityName));
                  int minDistVal = minDistance + enjoyingCity.get(minDistCityName);
//                  System.out.println(minDistVal + "  " + minStayVal);
                  if (Math.min(minDistVal, minStayVal) <= allowedTime)
                           if (minDistVal < minStayVal) {
                                    visitedCities.add(minDistCityName);
                                    allowedTime -= minDistVal;
                           } else {
                                    visitedCities.add(minStayCityName);
                                    allowedTime -= minStayVal;
                           }
                  else if (Math.min(minDistance, minStayTime) <= allowedTime)
                           if (minDistance < minStayTime) {
                                    visitedCities.add(minDistCityName);
                                    allowedTime -= minDistance;
                           } else {
                                    visitedCities.add(minStayCityName);
                                    allowedTime -= minStayVal;
                           }
                  else {
                           allowedDay--;
                           allowedTime = 16;
                           if (allowedDay > 0)
                                    solve(visitedCities.get(visitedCities.size() - 1));
                  }
                  if ((allowedDay > 0 || allowedTime >= 0)
                          && !visitedCities.get(visitedCities.size() - 1).equals(lastCity))
                           solve(visitedCities.get(visitedCities.size() - 1));

         }

         // <editor-fold defaultstate="collapsed" desc="collectTravellingPreferences ">
         private static void collectTravellingPreferences(String[] x, int idx) {
                  List<String> cities = null;
                  List<Integer> tt = null;
                  if (connectedCitiesName.get(x[idx]) != null) {
                           cities = connectedCitiesName.get(x[idx].replaceAll("\\s+$", ""));
                           tt = travellingTime.get(x[idx].replaceAll("\\s+$", ""));
                  } else {
                           cities = new ArrayList<>();
                           tt = new ArrayList<>();
                  }
                  cities.add(x[idx == 0 ? 1 : 0].replaceAll("\\s+$", ""));
                  tt.add(Integer.parseInt(x[2].replaceAll("\\s+$", "")));
                  connectedCitiesName.put(x[idx].replaceAll("\\s+$", ""), cities);
                  travellingTime.put(x[idx].replaceAll("\\s+$", ""), tt);
         }
// </editor-fold>
}
