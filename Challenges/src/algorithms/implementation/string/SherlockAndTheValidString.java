/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation.string;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nesrin
 */
public class SherlockAndTheValidString {

         public static List<String> solve(List<String> names) {
                  List<String> result = new ArrayList<>();
                  Map<String, String> nickNamesMap = new LinkedHashMap<>();
                  for (int i = 0; i < names.size(); i++) {
                           int occurrences = Collections.frequency(names, names.get(i));
                           if (occurrences > 1) {
                                    int cunt = 1;
                                    for (Map.Entry<String, String> entry : nickNamesMap.entrySet()) {
                                             String value = entry.getValue();
                                             if (value.equals(names.get(i)))
                                                      cunt++;
                                    }
                                    if (cunt > 1)
                                             nickNamesMap.put(names.get(i) + " " + cunt, names.get(i));
                                    else
                                             calculate(names.get(i), nickNamesMap, names.subList(0, i + 1));
                           } else
                                    //     String availableNickname = nickNamesMap.get(names.get(i));
                                    nickNamesMap = calculate(names.get(i), nickNamesMap, names.subList(0, i + 1));
                  }
                  for (Map.Entry<String, String> entry : nickNamesMap.entrySet())
                           result.add(entry.getKey()); //                           String value = entry.getValue();
                  return result;
                  // Write your code here

         }

         static String timeConversion(String s) {
                  String[] ints = s.substring(0, 8).split(":");
                  return ((s.charAt(8) == 'A') ? (Integer.parseInt(ints[0]) == 12 ? "00" : ints[0]) : (Integer.parseInt(ints[0]) == 12 ? "12" : Integer.parseInt(ints[0]) + 12)) + ":" + ints[1] + ":" + ints[2];
         }

         // Complete the isValid function below.
         static String isValid(String s) {
                  Map<Character, Integer> charMap = new HashMap<>();
                  Map<Integer, List<Character>> countMap = new HashMap<>();
                  int max = Integer.MIN_VALUE;
                  int min = Integer.MAX_VALUE;
                  for (char c : s.toCharArray())
                           charMap.put(c, charMap.getOrDefault(c, 0) + 1);

                  System.out.println(charMap);
                  for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                           List<Character> chars = countMap.get(entry.getValue());

                           if (null == chars || chars.isEmpty())
                                    chars = new ArrayList<>();

                           chars.add(entry.getKey());
                           countMap.put(entry.getValue(), chars);

                           if (max < entry.getValue())
                                    max = entry.getValue();
                           if (min > entry.getValue())
                                    min = entry.getValue();
                  }
                  System.out.println(countMap);
                  String result = "YES";
                  if (countMap.size() > 2)
                           result = "NO";
                  else if (countMap.size() == 2) {
                           List<Integer> x = new ArrayList<>();
                           countMap.entrySet().forEach((entry) -> {
                                    x.add(entry.getValue().size());
                           });
                           if (x.get(0) == 1 || x.get(1) == 1 && max - min == 1)
                                    result = "YES";
                           else
                                    result = "NO";
                  } else if (max - min > 1)
                           result = "NO";
                  return result;

         }

         public static void main(String[] args) {
                  List<String> s = new ArrayList<String>();
                  //mary
//stacy
//sam
//samuel
//sam
//miguel
                  s.add("mary");
                  s.add("stacy");
                  s.add("sam");
                  s.add("samuel");
                  s.add("sam");
                  s.add("miguel");
                  System.out.println(solve(s));
//                  System.out.println(timeConversion("07:05:45PM"));
//                  System.out.println(timeConversion("12:05:39AM"));
//                  System.out.println(timeConversion("06:40:03AM"));
//                  System.out.println(timeConversion("12:45:54PM"));
                  //       isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd");
         }

         private static Map<String, String> calculate(String currentName, Map<String, String> nickNamesMap, List<String> names) {

                  int index = 0;
                  while (index < currentName.length()) {
                           index++;
                           String subs = nickNamesMap.get(currentName.substring(0, index));
                           boolean used = false;
                           if (subs == null) {
                                    int count = 0;
                                    for (int i = 0; i < names.size(); i++)
                                             if (!names.get(i).equals(currentName) 
                                                     && names.get(i).substring(0, 
                                                             currentName.substring(0, Math.min(index, names.get(i).length())).length())
                                                        .equals(
                                                                currentName.substring(0, index)))
                                             {
                                                      used = true;
                                                      break;
                                             }
                                    if (used)
                                             continue;
//                                    if()
                                    nickNamesMap.put(currentName.substring(0, index), currentName);
                                    break;
                           }
                  }
                  return nickNamesMap;
         }

}
