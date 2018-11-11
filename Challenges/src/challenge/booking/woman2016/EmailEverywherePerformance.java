/*
https://www.hackerrank.com/contests/booking-womenintech-2017/challenges/emails-emails-everywhere/problem
 */
package challenge.booking.woman2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Nesrin
 */
public class EmailEverywherePerformance {

         public static void main(String[] args) throws Exception {

//                  Scanner s = new Scanner(System.in);
                  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//                  BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\e0.txt")));
                  Queue<ComparableQueue> pq = new PriorityQueue();
                  int cnt = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));
                  //s.nextLine();
                  for (int i = 0; i < cnt; i++) {
                           String[] record = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                           if (record.length == 3)
                                    pq.add(new ComparableQueue(Integer.parseInt(record[2]), record[1], i));
                           else if (pq.isEmpty())
                                    System.out.println(-1);
                           else
                                    System.out.println(pq.poll().getEmail()); //                                    pq.remove();
                  }

         }
}

class ComparableQueue implements Comparable<ComparableQueue> {

         private int priority;
         private String email;
         private int index;

         public ComparableQueue(int priority, String email, int index) {
                  this.priority = priority;
                  this.email = email;
                  this.index = index;
         }

         @Override
         public int compareTo(ComparableQueue co) {
                  int coPriority = co.getPriority();
                  if (this.getPriority() < coPriority)
                           return 1;
                  else if (this.getPriority() > coPriority)
                           return -1;
                  else if (this.getIndex() > co.index)
                           return 1;
                  return 0;
         }

         public int getPriority() {
                  return priority;
         }

         public void setPriority(int priority) {
                  this.priority = priority;
         }

         public String getEmail() {
                  return email;
         }

         public void setEmail(String email) {
                  this.email = email;
         }

         public int getIndex() {
                  return index;
         }

         public void setIndex(int index) {
                  this.index = index;
         }
}
