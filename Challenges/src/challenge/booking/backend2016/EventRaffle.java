/*
https://www.hackerrank.com/contests/booking-passions-hacked-backend/challenges/lottery-ii
 */
package challenge.booking.backend2016;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
public class EventRaffle {

         static boolean still = true;
         static Integer emptyOption = 0;
         // use map to keep the ticket IDs (List<Integer>), 
         //including any of person passions with the person Id as key (Integer)
         // collect the IDs of tickets, that matches alone a single person
         // and this person can't find another ticket including any of his passions
         static List<Integer> singleOption = new ArrayList<>();

         public static void main(String[] args) {
                  Scanner s = new Scanner(System.in);
                  int n = s.nextInt();
                  s.nextLine();
                  List<Person> persons = new ArrayList<>();
                  // collect persons data
                  System.out.println("1 "+LocalDateTime.now());
                  for (int i = 0; i < n; i++) {
                           List<String> person = Arrays.asList(s.nextLine().split(" "));
                           
//                           String[] passions = new ArrayList<>();
//                           for (int j = 2; j < Integer.parseInt(person[1]) + 2; j++)
//                                    passions.add(person[j]);
                           persons.add(new Person(i + 1, person.subList(2, Integer.parseInt(person.get(1))+2)));
                  }
                  // collect tickets data using same index person
                  // Note. ArrayList keep position of insertion
                  System.out.println("2 "+LocalDateTime.now());

                  List<Ticket> tickets = new ArrayList<>();
                  for (int i = 0; i < n; i++) {
                           String ticket[] = s.nextLine().split(" ");
                           List<String> passions = new ArrayList<>();
                           for (int j = 1; j < Integer.parseInt(ticket[0]) + 1; j++)
                                    passions.add(ticket[j]);
                           tickets.add(new Ticket(i + 1, passions));
                  }
//                  System.out.println(persons);
//                  System.out.println(tickets);
                  Map<Integer, List<Integer>> matches = new HashMap<>();
                  System.out.println("3 "+LocalDateTime.now());

                  for (int i = 0; i < persons.size(); i++) {
                           List<String> pp;
//                           List<String> tp = tickets.get(persons.get(i).getAssignedTicket() - 1).getPassions();
//                           // checking the presence of any of the person passion
//                           // in his own ticket from system input
//                           pp.retainAll(tp);
//                           // if no passion matches person's passion, then
//                           // collect the ids of other ticktecs that contains matching passion
//                           if (pp.isEmpty()) {
                           List<Integer> otherTickets = new ArrayList<>();
                           for (int j = 0; j < tickets.size(); j++) {
                                    List<String> tpj = tickets.get(j).getPassions();
                                    pp = new ArrayList<>(persons.get(i).getPassions());
                                    pp.retainAll(tpj);
                                    // whenever a ticket shows a person passion of current iteration
                                    // collect them in the map
                                    if (!pp.isEmpty())
                                             otherTickets.add(tickets.get(j).getId());
                           }

                           if (otherTickets.isEmpty())
                                    emptyOption++;
                           // whenever the tickets size includes single value collect it 
                           // to be excluded fron counting in the swaping step
                           else if (otherTickets.size() == 1)
                                    if (singleOption.contains(otherTickets.get(0)))
                                             emptyOption++;
                                    else
                                             singleOption.add(otherTickets.get(0));
                           else if (otherTickets.size() > 1)
                                    matches.put(persons.get(i).getId(), otherTickets);
                  }
                  System.out.println("4 "+LocalDateTime.now());

//                  System.out.println(singleOption);
//                  System.out.println(matches);
                  while (still)
                           matches = reduceMatches(matches);
                  System.out.println("5 "+LocalDateTime.now());

                  System.out.println(persons.size() - emptyOption);

         }

         private static Map<Integer, List<Integer>> reduceMatches(Map<Integer, List<Integer>> matches) {
                  List<Integer> entryListToBeRemoved = new ArrayList<>();
                  matches.entrySet().forEach((entry) -> {
                           //Integer key = entry.getKey();
                           List<Integer> value = entry.getValue();
                           value.removeAll(singleOption);
                           if (value.isEmpty()) {
                                    emptyOption++;
                                    entryListToBeRemoved.add(entry.getKey());

                           } else if (value.size() == 1) {
                                    singleOption.add(value.get(0));
                                    entryListToBeRemoved.add(entry.getKey());
//                                    emptyOption++;
                           }
                  });
                  for (int i = 0; i < entryListToBeRemoved.size(); i++)
                           matches.remove(entryListToBeRemoved.get(i));
//                  System.out.println("mach: "+ matches);
//                  System.out.println("sing: "+singleOption);
//                  System.out.println("emp: "+emptyOption);
                  if (matches.isEmpty())
                           still = false;
                  return matches;
         }

}

class Person {


         private Integer id;
         private List<String> passions;
//         private String[] passions;
         private Integer assignedTicket;

         public Person(Integer id, List<String> passions, Integer assignedTicket) {
                  this.id = id;
                  this.passions = passions;
                  this.assignedTicket = assignedTicket;
         }
         public Person(Integer id,List<String> passions) {
                  this.id = id;
                  this.passions = passions;
         }

         @Override
         public String toString() {
                  return "id: " + getId() + " ticket:" + getAssignedTicket() + " passions: " + getPassions();

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

}

class Ticket {

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

         private Integer id;
         private List<String> passions;

         public Ticket(Integer id, List<String> passions) {
                  this.id = id;
                  this.passions = passions;
         }

         @Override
         public String toString() {
                  return "id: " + getId() + " passions: " + getPassions();

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
}
