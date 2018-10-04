/*
https://www.hackerrank.com/contests/booking-passions-hacked-backend/challenges
 */
package challenge.booking.backend2016;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 3 4<br>
 * Skating <br>
 * Food <br>
 * Climbing <br>
 * 1 1467720000<br>
 * Skating is good in Austria <br>
 * 22 1464782400<br>
 * I loved the Spanish food, it had so many varieties and it<br>
 * was super super delicious. The price was a little bit high but it was worth
 * it. People who don't like spicy food might need to think twice as it could be
 * a little bit problematic for them. <br>
 * 4 1467720000<br>
 * I didn’t like the Indian food! <br>
 * 50 1467720000 People were really<br>
 * friendly, I enjoyed being there.<br>
 */
/**
 *
 * @author Nesrin
 */
public class Reviews {

         public static void main(String[] args) {

                  Scanner s = new Scanner(System.in);
                  String[] n = s.nextLine().split(" ");

                  List<String> passions = new ArrayList<>();
                  Map<Integer, List<GuestDetails>> guests = new HashMap<>();

                  for (int i = 0; i < Integer.parseInt(n[0]); i++)
//                  for (int i = 0; i < 1; i++)
                           passions.add(s.nextLine().toLowerCase());

                  int[][] dataTable = null;
                  for (int i = 0; i < Integer.parseInt(n[1]); i++) {
                           String[] guestID = s.nextLine().split(" ");
                           String guestReview = s.nextLine().toLowerCase();
                           Integer guestId = Integer.parseInt(guestID[0]);

                           GuestDetails gd = new GuestDetails(
                                   guestID[0], Long.parseLong(guestID[guestID.length - 1]), guestReview, passions
                           );

                           if (guests.get(guestId) == null) {
                                    List<GuestDetails> x = new ArrayList<>();
                                    x.add(gd);
                                    guests.put(guestId, x);
                           } else {
                                    List<GuestDetails> x = guests.get(guestId);
                                    x.add(gd);
                                    guests.put(guestId, x);
                           }
                  }
                  StringBuilder sb = new StringBuilder();
                  int index = 0;
                  dataTable = new int[guests.size()][passions.size() + 2];
                  for (Map.Entry<Integer, List<GuestDetails>> entry : guests.entrySet()) {
                           Integer key = entry.getKey();
                           List<GuestDetails> value = entry.getValue();
                           int score = 0;
                           dataTable[index][0] = key;
                           for (int i = 0; i < value.size(); i++) {
                                    score += value.get(i).getTotalPoints();
                                    for (int j = 2; j < value.get(i).getPassionsSum().length + 2; j++)
                                             dataTable[index][j] += value.get(i).getPassionsSum()[j - 2];
                           }
//                           System.out.println(score);
                           dataTable[index][1] = score;

                           index++;
                  }
                  for (int i = 0; i < passions.size(); i++) {
                           int minId = Integer.MAX_VALUE;
//                           int maxScore = Integer.MIN_VALUE;
                           int repetition = Integer.MIN_VALUE;
                           for (int[] dataTable1 : dataTable)

                                    if (dataTable1[i + 2] >= 1)
                                             if (dataTable1[i + 2] > repetition) {
                                                      repetition = dataTable1[i + 2];
                                                      minId = dataTable1[0];
                                             } else if (dataTable1[i + 2] == repetition)
                                                      if (dataTable1[0] < minId)
                                                               minId = dataTable1[0]; //                                             if (dataTable1[1] > maxScoreId)
                           //                                                      maxScoreId = dataTable1[0];
                           if (minId == Integer.MAX_VALUE)
                                    sb.append("-1").append("\n");
                           else
                                    sb.append(minId).append("\n");
                  }
                  System.out.println(sb.toString());
         }

}

class GuestDetails {

         private final LocalDateTime startDate = LocalDateTime.of(2016, Month.JUNE, 15, 0, 0);
         private final LocalDateTime endDate = LocalDateTime.of(2016, Month.JULY, 15, 0, 0);
         private final long startDateUnix = startDate.toEpochSecond(ZoneOffset.UTC);
         private final long endDateUnix = endDate.toEpochSecond(ZoneOffset.UTC);

         private String id;
         private Long unixTimestamp;
         private String review;
//         private int reviewCount;
         private int reviewPoints = 10;
         private LocalDateTime dateTime;
         private int datePoints = 10;
         private int totalPoints;
         private int[] passionsSum = null;
         private List<String> passions;

         public GuestDetails(String id, Long unixTimestamp, String review, List<String> passions) {
                  this.id = id;
                  this.unixTimestamp = unixTimestamp;
                  this.review = review;
//                  this.reviewCount = passions.size();
                  if (review.length() >= 100)
                           this.reviewPoints = 20;
                  this.dateTime
                          = LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTimestamp),
                                  ZoneOffset.UTC);
//                  if (dateTime.isAfter(startDate.minusDays(1)) && dateTime.isBefore(endDate.minusDays(1)))
                  if (unixTimestamp >= startDateUnix && unixTimestamp <= endDateUnix)
                           this.datePoints = 20;
                  this.totalPoints = reviewPoints + datePoints;
                  passionsSum = new int[passions.size()];
                  this.passions = passions;
                  fillPassionsArray();

         }

         private void fillPassionsArray() {

                  for (int i = 0; i < getPassionsSum().length; i++) {
                           Pattern p = Pattern.compile( getPassions().get(i).toLowerCase() );
                           Matcher m = p.matcher(getReview().toLowerCase());
                        
                           getPassionsSum()[i] = 0;
                           if (m.find()){
                                    getPassionsSum()[i] = totalPoints;
//                                       if ((id.equals("6") || id.equals("0")) && i==5)
//                                    System.out.println(totalPoints+" : shops: "+ id +" date: "+dateTime+" review: "+review.length());
                           }

                  }
         }

         /**
          * @return the startDate
          */
         public LocalDateTime getStartDate() {
                  return startDate;
         }

         /**
          * @return the endDate
          */
         public LocalDateTime getEndDate() {
                  return endDate;
         }

         /**
          * @return the dateTime
          */
         public LocalDateTime getDateTime() {
                  return dateTime;
         }

         /**
          * @param dateTime the dateTime to set
          */
         public void setDateTime(LocalDateTime dateTime) {
                  this.dateTime = dateTime;
         }

         /**
          * @return the id
          */
         public String getId() {
                  return id;
         }

         /**
          * @param id the id to set
          */
         public void setId(String id) {
                  this.id = id;
         }

         /**
          * @return the review
          */
         public String getReview() {
                  return review;
         }

         /**
          * @param review the review to set
          */
         public void setReview(String review) {
                  this.review = review;
         }

         /**
          * @return the unixTimestamp
          */
         public Long getUnixTimestamp() {
                  return unixTimestamp;
         }

         /**
          * @param unixTimestamp the unixTimestamp to set
          */
         public void setUnixTimestamp(Long unixTimestamp) {
                  this.unixTimestamp = unixTimestamp;
         }

//         /**
//          * @return the reviewCount
//          */
//         public int getReviewCount() {
//                  return reviewCount;
//         }
//
//         /**
//          * @param reviewCount the reviewCount to set
//          */
//         public void setReviewCount(int reviewCount) {
//                  this.reviewCount = reviewCount;
//         }
         /**
          * @return the reviewPoints
          */
         public int getReviewPoints() {
                  return reviewPoints;
         }

         /**
          * @param reviewPoints the reviewPoints to set
          */
         public void setReviewPoints(int reviewPoints) {
                  this.reviewPoints = reviewPoints;
         }

         /**
          * @return the datePoints
          */
         public int getDatePoints() {
                  return datePoints;
         }

         /**
          * @param datePoints the datePoints to set
          */
         public void setDatePoints(int datePoints) {
                  this.datePoints = datePoints;
         }

         /**
          * @return the totalPoints
          */
         public int getTotalPoints() {
                  return totalPoints;
         }

         /**
          * @param totalPoints the totalPoints to set
          */
         public void setTotalPoints(int totalPoints) {
                  this.totalPoints = totalPoints;
         }

         /**
          * @return the passionsSum
          */
         public int[] getPassionsSum() {
                  return passionsSum;
         }

         /**
          * @param passionsSum the passionsSum to set
          */
         public void setPassionsSum(int[] passionsSum) {
                  this.passionsSum = passionsSum;
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
