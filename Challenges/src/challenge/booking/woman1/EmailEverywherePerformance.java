/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.booking.woman1;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Nesrin
 */
public class EmailEverywherePerformance {

         public static void main(String[] args) {

                  Scanner s = new Scanner(System.in);
                  Queue<ComparableQueue> pq = new PriorityQueue();
                  int cnt = s.nextInt();
                  s.nextLine();
                  for (int i = 0; i < cnt; i++) {
                           String[] record = s.nextLine().split(" ");
                           if (record.length == 3)
                                    pq.add(new ComparableQueue(Integer.parseInt(record[2]), record[1], i));
                           else if (pq.isEmpty())
                                    System.out.println(-1);
                           else {
                                    System.out.println(pq.poll().getEmail());
//                                    pq.remove();
                           }
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
