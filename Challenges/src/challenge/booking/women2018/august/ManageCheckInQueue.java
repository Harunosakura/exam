package challenge.booking.women2018.august;


import java.io.*;
import static java.lang.Math.ceil;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Nesrin
 */
public class ManageCheckInQueue {

    static int solve(int m, List<List<Integer>> desks) {
        double totalPerMin = 0;
        int totalCust = m;
        double maxCurrentQue = 0;
        for (List<Integer> desk : desks) {
            totalPerMin += desk.get(0);
            totalCust += desk.get(1);
            if((double)desk.get(1)/desk.get(0)> maxCurrentQue)
                maxCurrentQue = (double)desk.get(1)/desk.get(0);
        }
        int maxMin =(int) Math.ceil(totalCust / totalPerMin);
        int returnVal;
//        System.out.println(desks);
//        System.out.println(m);
//        System.out.println(totalCust +" "+totalPerMin +" "+ maxCurrentQue);
//        System.out.println(maxMin);
        if(maxCurrentQue> maxMin)
            returnVal =  (int) Math.ceil(maxCurrentQue);
        else
            returnVal = maxMin;
        System.out.println(returnVal);
        return returnVal;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\que.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\result1.txt"));

        String[] nm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        List<List<Integer>> desks = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                desks.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = solve(m, desks);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
