
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Nesrin
 */
public class Busydays {

    static String solve(List<List<String>> reservations) {
        System.out.println(reservations);

        List<String> l = new ArrayList<>();
        for (List<String> reservation : reservations) {
            // Add both dates to the list but with a mark to know which is entry and which is exit
            l.add(reservation.get(0) + "0");
            l.add(reservation.get(1) + "1");
        }
        java.util.Collections.sort(l);
        System.out.println(l);
        int current = 0;
        int maximum = 0;
        String answer = "";
        for (String date : l) {
            if (date.charAt(10) == '0') {
                current += 1;
            } else {
                current -= 1;
            }
            if (current > maximum) {
                maximum = current;
                answer = date.substring(0, 10);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\test12.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\result1.txt"));

        int t = Integer.parseInt(bufferedReader.readLine().trim());
        if (t < 1 || t > 10) {
            throw new RuntimeException("Number Range Exception");
        }
        IntStream.range(0, t).forEach(tItr -> {

            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                if (n < 1 || n > (Math.pow(10, 5))) {
                    throw new RuntimeException("Number Range Exception");
                }
                List<List<String>> reservations = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        reservations.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = solve(reservations);
                System.out.println(result);
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

}
