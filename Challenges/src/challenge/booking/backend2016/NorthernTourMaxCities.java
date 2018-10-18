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
public class NorthernTourMaxCities {

         static Map<String, Integer> enjoyingCity = new HashMap<>();
         static final String START_POINT = "Bevagna";
         static Map<String, List<String>> connectedCitiesName = new HashMap<>();
         static Map<String, List<Integer>> travellingTime = new HashMap<>();
         static List<List<String>> visitedCities = new ArrayList<>();
//         static int allowedTime = 16;
//         static int allowedDay = 6;

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

class Node {

         private int stayTime;
         private int distTime;
         private int accumatedTime;
         private String cityName;
         private List<String> connectedCities;
         private List<Integer> connectedCitiesDist;
         private List<Node> nexts;

         public Node(int stayTime,
                 int distTime,
                 int accumatedTime,
                 String cityName,
                 List<String> connectedCities,
                 List<Integer> connectedCitiesDist,
                 List<Node> nexts) {

                  this.stayTime = stayTime;
                  this.distTime = distTime;
                  this.accumatedTime = accumatedTime;
                  this.cityName = cityName;
                  this.connectedCities = connectedCities;
                  this.connectedCitiesDist = connectedCitiesDist;
                  this.nexts = nexts;

         }

         /**
          * @return the stayTime
          */
         public int getStayTime() {
                  return stayTime;
         }

         /**
          * @param stayTime the stayTime to set
          */
         public void setStayTime(int stayTime) {
                  this.stayTime = stayTime;
         }

         /**
          * @return the distTime
          */
         public int getDistTime() {
                  return distTime;
         }

         /**
          * @param distTime the distTime to set
          */
         public void setDistTime(int distTime) {
                  this.distTime = distTime;
         }

         /**
          * @return the accumatedTime
          */
         public int getAccumatedTime() {
                  return accumatedTime;
         }

         /**
          * @param accumatedTime the accumatedTime to set
          */
         public void setAccumatedTime(int accumatedTime) {
                  this.accumatedTime = accumatedTime;
         }

         /**
          * @return the cityName
          */
         public String getCityName() {
                  return cityName;
         }

         /**
          * @param cityName the cityName to set
          */
         public void setCityName(String cityName) {
                  this.cityName = cityName;
         }

         /**
          * @return the connectedCities
          */
         public List<String> getConnectedCities() {
                  return connectedCities;
         }

         /**
          * @param connectedCities the connectedCities to set
          */
         public void setConnectedCities(List<String> connectedCities) {
                  this.connectedCities = connectedCities;
         }

         /**
          * @return the connectedCitiesDist
          */
         public List<Integer> getConnectedCitiesDist() {
                  return connectedCitiesDist;
         }

         /**
          * @param connectedCitiesDist the connectedCitiesDist to set
          */
         public void setConnectedCitiesDist(List<Integer> connectedCitiesDist) {
                  this.connectedCitiesDist = connectedCitiesDist;
         }

         /**
          * @return the nexts
          */
         public List<Node> getNexts() {
                  return nexts;
         }

         /**
          * @param nexts the nexts to set
          */
         public void setNexts(List<Node> nexts) {
                  this.nexts = nexts;
         }

}
