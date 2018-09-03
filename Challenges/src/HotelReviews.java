import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author Nesrin
 */
public class HotelReviews {

    // Complete the sort_hotels function below.
    static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {
        System.out.println(LocalDateTime.now().toString());
        System.out.println("list size" + hotel_ids.size());
        List<Integer> listWithoutDuplicates = hotel_ids.stream()
                .distinct().sorted()
                .collect(Collectors.toList());
        System.out.println(LocalDateTime.now().toString() + " listWithoutDuplicates: " + listWithoutDuplicates);
        StringBuilder[] collectedReviews = new StringBuilder[listWithoutDuplicates.size()];
        for (int i = 0; i < collectedReviews.length; i++) {
            collectedReviews[i] = new StringBuilder();
        }

        Map<Integer, Integer> hotelReviewsCount = new HashMap<>();
        for (int i = 0; i < hotel_ids.size(); i++) {

            collectedReviews[(hotel_ids.get(i) - 1)].append(reviews.get(i)//.replaceAll(",", "") .replaceAll("\\.", "")
                    .toLowerCase());//collectedReviews[hotel_ids-1].append(reviews.get(i));
        }
        System.out.println("Start getCountOfWordsInSingleReview: " + LocalDateTime.now().toString());

        for (int i = 0; i < collectedReviews.length; i++) 
            hotelReviewsCount.put(i + 1, getCountOfWordsInSingleReview(keywords, collectedReviews[i].toString()));
        
        System.out.println("End getCountOfWordsInSingleReview: " + LocalDateTime.now().toString());
        List<Integer> orderedIds = new LinkedList<>();
        Stream<Map.Entry<Integer, Integer>> x
                = hotelReviewsCount
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        x.forEachOrdered(a -> orderedIds.add(a.getKey()));
        System.out.println(LocalDateTime.now().toString());
        
        return orderedIds;
    }

    private static int getCountOfWordsInSingleReview(String requiredWords, String review) {
        int x = 0;
        String[] reqWords = requiredWords.split(" ");
        for (String reqWord : reqWords) {
            Pattern p = Pattern.compile(reqWord);
            Matcher m = p.matcher(review);
            while (m.find()) {
                x++;
            }
        }
        return x;
    }

    public static void main(String[] args) {

        String keywords = "breakfast beach citycenter location metro view staff price";
        List<Integer> hotel_ids = new ArrayList<>();
        List<String> reviews = new ArrayList<>();

        for (int i = 0; i < 200000; i++) {
            hotel_ids.add(1);
            reviews.add("breakfast  citycenterlocationmetro view staff price"
                    + "breakfast beach citycenter  metro view staff price"
                    + "breakfast beach  location metro  staff price"
                    + "breakfast beach citycenter location metro view staff price"
                    + "breakfast beach citycenter  metro view staff price");
            hotel_ids.add(2);
            reviews.add("breakfast beach citycenterlocationmetro view staff price"
                    + "breakfast beach citycenter location metro view staff price"
                    + "breakfast beach citycenter location metro view staff price"
                    + "breakfast beach citycenter location metro view staff price"
                    + "breakfast beach citycenter location metro view staff price");
            hotel_ids.add(3);
            reviews.add("breakfast beach citycenterlocationmetro view staff price"
                    + "breakfast beach citycenter location metro view staff price"
                    + "breakfast beach citycenter  metro view staff price"
                    + "breakfast beach citycenter location metro view staff price"
                    + "breakfast beach  location metro view staff price");
            hotel_ids.add(4);
            reviews.add("breakfast beach citycenterlocationmetro view staff price"
                    + "breakfast beach citycenter location metro view staff price"
                    + "breakfast beach citycenter location metro view staff price"
                    + "breakfast beach citycenter location metro view staff price"
                    + "breakfast beach citycenter location metro view staff price");
        }
        System.out.println(sort_hotels(keywords, hotel_ids, reviews));
    }
}
