/*
https://www.hackerrank.com/contests/booking-passions-hacked-backend/challenges/lottery-ii
https://www.geeksforgeeks.org/maximum-bipartite-matching/
 */
package challenge.booking.backend2016;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * Output Format<br>
 *
 * Print a single integer denoting the maximum number of people who can be happy
 * with their event ticket, meaning that they have (either as their original
 * ticket or one received through trading with another group member) a ticket to
 * an event satisfying one or more of their passions.<br>
 *
 * <strong>Sample Input</strong><br>
 *
 * 3<br>
 * 1 3 museum wine_tasting biking<br>
 * 3 2 museum flower_parade<br>
 * 2 2 hiking biking<br>
 * 1 flower_parade<br>
 * 1 museum<br>
 * 2 biking wine_tasting<br>
 * <strong>Sample Output</strong><br>
 *
 * 3<br>
 */
public class EventRaffleDFS {

         static Integer assigned = 0;
         static int matchR[] = null;
//         static Integer emptyMatches = 0;
         // use map to keep the ticket IDs (List<Integer>), 
         //including any of person passions with the person Id as key (Integer)
         // collect the IDs of tickets, that matches alone a single person
         // and this person can't find another ticket including any of his passions

         public static void main(String[] args) throws IOException {
//                  System.out.println("1 " + LocalDateTime.now());
//                  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                  BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\pt7.txt")));
//                  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\result1.txt"));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//                  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
                  int t = Integer.parseInt(bufferedReader.readLine().trim());
                  matchR = new int[t];
                  IntStream.range(0, t).forEach(tItr -> {
//                           System.out.println("2 " + LocalDateTime.now());

                           try {
                                    List<PersonTickets> persons = new ArrayList<>();
                                    IntStream.range(0, t).forEach(i -> {
                                             matchR[i] = -1;
                                             try {
                                                      List<String> x = null;
                                                      x = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                                              .collect(toList());
                                                      persons.add(new PersonTickets(i, x));

                                             } catch (IOException ex) {
                                                      throw new RuntimeException(ex);
                                             }
                                    });
//                                    System.out.println("3 " + LocalDateTime.now());

//                                    List<TicketP> tickets = new ArrayList<>();
                                    IntStream.range(0, t).forEach(i -> {
                                             try {
                                                      List<String> x = null;
                                                      x = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                                              .collect(toList());
                                                      x.remove(0);
                                                      Collections.sort(x);
                                                      for (int j = 0; j < persons.size(); j++)
                                                               if (matchUsefulTickets(persons.get(j), x)) {
                                                                        List<Integer> usefulTickets = persons.get(j).getMachingTickets();
                                                                        if (null == usefulTickets)
                                                                                 usefulTickets = new ArrayList<>();
                                                                        usefulTickets.add(i);
                                                                        persons.get(j).setMachingTickets(usefulTickets);
                                                               }

                                             } catch (IOException ex) {
                                                      throw new RuntimeException(ex);
                                             }
                                    });
//                                    System.out.println("4 " + LocalDateTime.now());
//                                    System.out.println(persons);

                                    solve(persons);
                           } catch (Exception ex) {
//                                    throw new RuntimeException(ex);
                           }
                  });

                  bufferedReader.close();
//                  bufferedWriter.close();
         }

         private static void solve(List<PersonTickets> persons) {
                  for (int i = 0; i < persons.size(); i++) {
                           // boolean seen[] = new boolean[matchR.length];

                           boolean cc = dfs(persons, i, new boolean[matchR.length]);
//                           System.out.println(cc);
                           if (cc)
                                    assigned++;
                  }
                  for (int i = 0; i < matchR.length; i++)
                           System.out.println(i + " " + matchR[i]);
                  System.out.println(assigned);
         }
         // A DFS based recursive function that  
         // returns true if a matching for  
         // vertex u is possible 

         private static boolean dfs(List<PersonTickets> persons, int u, boolean seen[]) {
                  // boolean seen[] = new boolean[matchR.length];
                  // Try every job one by one 
                  if (null == persons.get(u).getMachingTickets() || persons.get(u).getMachingTickets().isEmpty())
                           return false;
                  for (int v = 0; v < matchR.length; v++) {
                           // If applicant u is interested  
                           // in job v and v is not visited 
//                           persons.get(u).getMachingTickets().contains(v)
                           System.out.println("ticket: " + v + " User : " + u + " avai  : " + persons.get(u).getMachingTickets());

                           if (persons.get(u).getMachingTickets().contains(v)
                                   && !seen[v]) {

                                    // Mark v as visited 
                                    seen[v] = true;

                                    // If job 'v' is not assigned to 
                                    // an applicant OR previously 
                                    // assigned applicant for job v (which 
                                    // is matchR[v]) has an alternate job available. 
                                    // Since v is marked as visited in the  
                                    // above line, matchR[v] in the following 
                                    // recursive call will not get job 'v' again 
                                    if (matchR[v] < 0 || dfs(persons,  matchR[v],
                                            seen)) {
                                             matchR[v] = u;
                                             System.out.println("====================");
                                             return true;
                                    }
                           }
                  }
                  return false;
         }
// <editor-fold defaultstate="collapsed" desc="matchUsefulTickets method ">

         private static boolean matchUsefulTickets(PersonTickets pt, List<String> ticketPassions) {
                  for (int i = 0; i < ticketPassions.size(); i++)
                           if (pt.getPassions().contains(ticketPassions.get(i)))
                                    return true;
                  return false;
         }
// </editor-fold>

}
// <editor-fold defaultstate="collapsed" desc="PersonTickets Class">

class PersonTickets {

         private Integer id;
         private List<String> passions;
         private Integer assignedTicket;
         private String[] passionsArr;
         private List<Integer> machingTickets;

         public PersonTickets(Integer id, String[] passionsArr, Integer assignedTicket) {
                  this.id = id;
                  this.passionsArr = passionsArr;
                  this.assignedTicket = assignedTicket;
         }

         public PersonTickets(Integer id, String[] passionsArr) {
                  this.id = id;
                  this.passionsArr = passionsArr;
         }

         public PersonTickets(Integer id, List<String> passions) {
                  this.id = id;
                  this.passions = passions.subList(2, passions.size());
                  Collections.sort(this.passions);
         }

         public PersonTickets(Integer id, List<String> passions, Integer assignedTicket) {
                  this.id = id;
                  this.passions = passions;
                  this.assignedTicket = assignedTicket;
         }

         @Override
         public String toString() {
                  return "id: " + getId() + " tickets: " + getMachingTickets() + "\n";

         }

         /**
          * @return the machingTickets
          */
         public List<Integer> getMachingTickets() {
                  return machingTickets;
         }

         /**
          * @param machingTickets the machingTickets to set
          */
         public void setMachingTickets(List<Integer> machingTickets) {
                  this.machingTickets = machingTickets;
         }

         /**
          * @return the passionsArr
          */
         public String[] getPassionsArr() {
                  return passionsArr;
         }

         /**
          * @param passionsArr the passionsArr to set
          */
         public void setPassionsArr(String[] passionsArr) {
                  this.passionsArr = passionsArr;
         }

         /**
          * @return the id
          */
         public Integer getId() {
                  return id;
         }

         /**
          * @param id the id to set
          */
         public void setId(Integer id) {
                  this.id = id;
         }

         /**
          * @return the passions
          */
         public List<String> getPassions() {
                  return passions;
         }

         /**
          * @param passions the passions to set
          */
         public void setPassions(List<String> passions) {
                  this.passions = passions;
         }

         /**
          * @return the assignedTicket
          */
         public Integer getAssignedTicket() {
                  return assignedTicket;
         }

         /**
          * @param assignedTicket the assignedTicket to set
          */
         public void setAssignedTicket(Integer assignedTicket) {
                  this.assignedTicket = assignedTicket;
         }
}
// </editor-fold>
