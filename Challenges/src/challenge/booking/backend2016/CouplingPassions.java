/*
https://www.hackerrank.com/contests/booking-passions-hacked-backend/challenges
 */
package challenge.booking.backend2016;

import static java.lang.Math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Nesrin
 */
public class CouplingPassions {

         private static final double PI = 3.14159265359;

         public static void main(String[] args) {
                  /**
                   * 2<br>
                   * 3 surfing yoga walking <br>
                   * 3 wine relaxation beach <br>
                   * 3<br>
                   * amsterdam 52.374030 4.889690 4 museums canals nightlife
                   * walking<br>
                   * sagres 37.129665 -8.669586 3 beach surfing relaxation<br>
                   * biarritz 43.480120 -1.555580 6 surfing nightlife beach food
                   * wine walking<br>
                   */
                  Scanner s = new Scanner(System.in);
                  int n = s.nextInt();
                  s.nextLine();
                  Map<Integer, List<String>> guests = new HashMap<>();
                  List<String> guestsPassion = new ArrayList<>();
                  List<List<String>> availablePassion = new ArrayList<>();
                  List<Location> locations = new ArrayList<>();
                  for (int i = 0; i < n; i++) {
                           String[] guest = s.nextLine().split(" ");
                           List<String> asList = Arrays.asList(guest);
                           guests.put(i, asList.subList(1, guest.length));
                           guestsPassion.addAll(asList.subList(1, guest.length));
                  }
                  int l = s.nextInt();
                  s.nextLine();

                  for (int i = 0; i < l; i++) {
                           String[] guest = s.nextLine().split(" ");
                           List<String> asList = Arrays.asList(guest);
                           locations.add(
                                   new Location(
                                           guest[0],
                                           Double.parseDouble(guest[1]),
                                           Double.parseDouble(guest[2])
                                   ));
                           availablePassion.add(asList.subList(4, guest.length));
                  }
                  List<String> list1 = null;
                  List<String> list2 = null;
                  Set<String> common = null;
                  int max = 0;
                  Map<List<Location>, Integer> cities = new LinkedHashMap<>();
                  for (int i = 0; i < availablePassion.size() - 1; i++) {
                           //common = new HashSet<>();

                           for (int j = i + 1; j < availablePassion.size(); j++) {
                                    list1 = new ArrayList<>(guestsPassion);
                                    list2 = new ArrayList<>(guestsPassion);
                                    common = new HashSet<>();
                                    list1.retainAll(availablePassion.get(i));
                                    list2.retainAll(availablePassion.get(j));
                                    //System.out.println(common);
                                    common.addAll(list1);
                                    common.addAll(list2);
                                    if (common.size() > max)
                                             max = common.size();
                                    //System.out.println(max);
                                    //System.out.println(common);
                                    List<Location> c = new ArrayList<>();
                                    c.add(locations.get(i));
                                    c.add(locations.get(j));
                                    //System.out.println(locations.get(i).getLocName() + " " + locations.get(j).getLocName());
//                                    //System.out.println(locations.get(j));
                                    cities.put(c, common.size());
//                                    }//else if()
                           }
                  }
                  findMaxLocation(cities, max);
         }

         private static void findMaxLocation(Map<List<Location>, Integer> cities, int max) {
                  List<String> citiesNames = new ArrayList<>();
                  List<List< Location>> maxPassionLocations = new ArrayList<>();
                  cities.entrySet().stream().filter((entry) -> (entry.getValue() == max)).forEachOrdered((entry) -> {
                           maxPassionLocations.add(entry.getKey());
                  });
                  List<Location> x;
                  if (maxPassionLocations.size() > 1) {
                           x = findNearstLocations(maxPassionLocations);
                           citiesNames.add(x.get(0).getLocName());
                           citiesNames.add(x.get(1).getLocName());
                  } else {
                           citiesNames.add(maxPassionLocations.get(0).get(0).getLocName());
                           citiesNames.add(maxPassionLocations.get(0).get(1).getLocName());
                  }
                  Collections.sort(citiesNames);
                  System.out.print(citiesNames.get(0) + " " + citiesNames.get(1));
         }

         private static List<Location> findNearstLocations(List<List<Location>> maxPassionLocations) {
                  List<Double> distances = new ArrayList<>();
                  double min = Double.MAX_VALUE;
                  for (int i = 0; i < maxPassionLocations.size(); i++) {
                           List<Location> locs = maxPassionLocations.get(i);
                           Double x = distanceBetween(locs.get(0), locs.get(1));
                           if (x < min)
                                    min = x;
                           distances.add(x);
                  }
                  return maxPassionLocations.get(distances.indexOf(min));
         }

         private static double degree2radians(double degree) {
                  return degree * PI / 180;
         }

         private static Double distanceBetween(Location point1, Location point2) {
                  final long EARTH_RADIUS = 6371;//in km
                  double point1_lat_in_radians = degree2radians(point1.getLat());
                  double point2_lat_in_radians = degree2radians(point2.getLat());
                  double point1_long_in_radians = degree2radians(point1.getLon());
                  double point2_long_in_radians = degree2radians(point2.getLon());

                  return acos(
                          sin(point1_lat_in_radians) * sin(point2_lat_in_radians)
                          + cos(point1_lat_in_radians) * cos(point2_lat_in_radians)
                          * cos(point2_long_in_radians - point1_long_in_radians)
                  ) * EARTH_RADIUS;
         }
}

class Location {

         private String locName;
         private Double lat;
         private Double lon;
         //       private List<String> pasions;

         public Location(String locName, Double lat, Double lon) {
                  // public Location(String locName, Double lat, Double lon, List<String> pasions) {
                  this.locName = locName;
                  this.lat = lat;
                  this.lon = lon;
                  //              this.pasions = pasions;
         }

         /**
          * @return the locName
          */
         public String getLocName() {
                  return locName;
         }

         /**
          * @param locName the locName to set
          */
         public void setLocName(String locName) {
                  this.locName = locName;
         }

         /**
          * @return the lat
          */
         public Double getLat() {
                  return lat;
         }

         /**
          * @param lat the lat to set
          */
         public void setLat(Double lat) {
                  this.lat = lat;
         }

         /**
          * @return the lon
          */
         public Double getLon() {
                  return lon;
         }

         /**
          * @param lon the lon to set
          */
         public void setLon(Double lon) {
                  this.lon = lon;
         }
}
