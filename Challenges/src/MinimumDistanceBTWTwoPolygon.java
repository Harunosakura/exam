
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Nesrin
 */
public class MinimumDistanceBTWTwoPolygon {

    // Complete the solve function below.
    static double solve(List<List<Integer>> p, List<List<Integer>> q) {
//        confirmPositiveArea(p);
//        confirmPositiveArea(q);
        double minLength = 100000000;
        for (List<Integer> qq : q) {
            for (List<Integer> pp : p) {
                double current = distanceBTWPoints(pp, qq);
                if (current < minLength) {
                    minLength = current;
                }
            }
        }
        System.out.println(minLength);
        return minLength;
    }

    static double distanceBTWPoints(List<Integer> p, List<Integer> q) {
        int xDiff = q.get(0) - p.get(0);
        int yDiff = q.get(1) - p.get(1);
        System.out.println(+p.get(0) + "  " + q.get(0) + "  " + p.get(1) + "  " + q.get(1) + " x:" + xDiff + "  y: " + yDiff + " p: " + ((xDiff * xDiff) + (yDiff * yDiff)) + " VAl= " + Math.sqrt((xDiff * xDiff) + (yDiff * yDiff)));
//        System.out.println("p.get(0): "+p.get(0) +"  q.get(0) :"+q.get(0) +"  p.get(1):  "+p.get(1) +"  q.get(1): "+q.get(1) +" xDiff: " + xDiff + "  yDiff: " + yDiff + " plus: "+((xDiff * xDiff) + (yDiff * yDiff))+ " VAl= " + Math.sqrt((xDiff * xDiff) + (yDiff * yDiff)));
        return Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
    }
    
    private static boolean confirmPositiveArea(List<List<Integer>> p) {
        if (p.stream().anyMatch((list) -> (list.get(0) > -1 || list.get(1) > -1))) {
            return true;
        }
        throw new RuntimeException("no positive area");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\len6.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\result1.txt"));
        String[] nm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        List<List<Integer>> p = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                p.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> q = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                q.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        double result = solve(p, q);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static void main1(String[] args) {

        List<List<Integer>> p = new ArrayList<>();
        List<List<Integer>> q = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(1);
        p.add(list1);
        list1 = new ArrayList<>();
        list1.add(10);
        list1.add(1);
        p.add(list1);
        list1 = new ArrayList<>();
        list1.add(10);
        list1.add(5);
        p.add(list1);
        list1 = new ArrayList<>();
        list1.add(2);
        list1.add(5);
        p.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(15);
        list2.add(10);
        q.add(list2);
        list2 = new ArrayList<>();
        list2.add(20);
        list2.add(10);
        q.add(list2);
        list2 = new ArrayList<>();
        list2.add(20);
        list2.add(15);
        q.add(list2);
        list2 = new ArrayList<>();
        list2.add(15);
        list2.add(15);
        q.add(list2);
        System.out.println(solve(p, q));
    }

}
