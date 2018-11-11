package challenge.booking.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Map;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nesrin
 */
public class HotelReviews {

         // Complete the sort_hotels function below.
         static List<Integer> solve(List<String> keywords, Map<Integer, StringBuilder> hotelReviewsCount) {
                  System.out.println("3 : " + LocalDateTime.now().toString());

//                  for (int i = 0; i < hotel_ids.size(); i++)
//                           collectedReviews[(hotel_ids.get(i) - 1)].append(reviews.get(i)//.replaceAll(",", "") .replaceAll("\\.", "")
//                                   .toLowerCase());//collectedReviews[hotel_ids-1].append(reviews.get(i));
//                  System.out.println("Start getCountOfWordsInSingleReview: " + LocalDateTime.now().toString());
//
//                  for (int i = 0; i < collectedReviews.length; i++)
//                           hotelReviewsCount.put(i + 1, getCountOfWordsInSingleReview(keywords, collectedReviews[i].toString()));
//
//                  System.out.println("End getCountOfWordsInSingleReview: " + LocalDateTime.now().toString());
//                  List<Integer> orderedIds = new LinkedList<>();
//                  Stream<Map.Entry<Integer, Integer>> x
//                          = hotelReviewsCount
//                                  .entrySet()
//                                  .stream()
//                                  .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed());
//                  x.forEachOrdered(a -> orderedIds.add(a.getKey()));
//                  System.out.println(LocalDateTime.now().toString());
                  return null;
         }

         private static int getCountOfWordsInSingleReview(String requiredWords, String review) {
                  int x = 0;
                  String[] reqWords = requiredWords.split(" ");
                  for (String reqWord : reqWords) {
                           Pattern p = Pattern.compile(reqWord);
                           Matcher m = p.matcher(review);
                           while (m.find())
                                    x++;
                  }
                  return x;
         }

         public static void main(String[] args) throws Exception {

                  List<Integer> hotel_ids = new ArrayList<>();
                  List<String> reviews = new ArrayList<>();
                  List<String> keywords = new ArrayList<>();
//                  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//                  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

                  BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\hr.txt")));
                  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\result1.txt"));
                  Map<Integer, StringBuilder> hotelReviewsCount = new HashMap<>();

                  int t = 800000;// Integer.parseInt(bufferedReader.readLine().trim());
                  System.out.println("1 : " + LocalDateTime.now().toString());
//                  try (Stream<String> inputStream = Files.lines(Paths.get("C:\\java\\hr.txt"), StandardCharsets.UTF_8)) {
//                           inputStream.forEach(line -> {
//                                    reviews.add(line);
//                           });
                           inputStream.forEach(i -> {
                                    try {
                                             hotel_ids.add(Integer.parseInt(i.replaceAll("\\s+$", "")));
                                             reviews.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
                                    } catch (IOException ex) {
//                                             Logger.getLogger(HotelReviews.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                           });
                  }
//                  Stream.forEach(i -> {
//                           try {
//                                    hotel_ids.add(Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", "")));
//                                    reviews.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
//
////                                    hotelReviewsCount.put(id, hotelReviewsCount.getOrDefault(id, new StringBuilder().append("##  ")).append(review));
//                           } catch (IOException ex) {
//                                    throw new RuntimeException(ex);
//                           }
//                  });
                  System.out.println("2 : " + LocalDateTime.now().toString());

                  solve(keywords, hotelReviewsCount);
//                  bufferedReader.close();
//                  bufferedWriter.close();

                  //      System.out.println(sort_hotels(keywords, hotel_ids, reviews));
         }
}
