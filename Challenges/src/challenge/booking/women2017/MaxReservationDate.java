package challenge.booking.women2017;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Stream;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Nesrin
 */
public class MaxReservationDate {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static LocalDate minDate = LocalDate.parse("2018-01-01", formatter);
    static LocalDate maxDate = LocalDate.parse("2020-12-31", formatter);

    static String solve(List<List<String>> reservations) {
        List<List<LocalDate>> datesList = new ArrayList<>();
        System.out.println(LocalDateTime.now().toString());
        reservations.stream().forEach(range -> {
            List<LocalDate> collect = range.stream().map(date -> LocalDate.parse(date, formatter)).collect(Collectors.toList());
            datesList.add(collect);
        });
        System.out.println(LocalDateTime.now().toString());

        datesList.removeIf(x -> {
            if (x.get(0).isBefore(minDate)
                    || x.get(0).isAfter(x.get(1))
                    || x.get(1).isAfter(maxDate)) {
                return true;
            }
            return false;
        });
        System.out.println(LocalDateTime.now().toString());

        Stream<LocalDate> dateRanges = datesList.stream().flatMap(singleDateRange
                -> Stream.iterate(singleDateRange.get(0), d -> d.plusDays(1))
                        .limit(ChronoUnit.DAYS.between(singleDateRange.get(0), singleDateRange.get(1).plusDays(1))
                        ));
        System.out.println(LocalDateTime.now().toString());

        Map<LocalDate, Long> datesFrequency = dateRanges.
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(LocalDateTime.now().toString());

        long maxValue = (datesFrequency.entrySet().stream().max(Map.Entry.comparingByValue(Long::compareTo)).get().getValue());
        System.out.println(LocalDateTime.now().toString());

        Map<LocalDate, Long> collect = datesFrequency.entrySet().stream()
                .filter(x -> maxValue == x.getValue())
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        System.out.println(LocalDateTime.now().toString());

        LocalDate key = collect.entrySet().stream().min(Map.Entry.comparingByKey()).get().getKey();
        System.out.println(LocalDateTime.now().toString());

        return key.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\test6.txt")));
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
