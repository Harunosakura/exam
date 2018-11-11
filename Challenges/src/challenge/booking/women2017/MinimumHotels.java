package challenge.booking.women2017;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nesrin
 */
public class MinimumHotels {

    static int solve(List<Integer> customer, int k) {
        int hotelsCount = 1;
        Collections.sort(customer);
         int customerIndx = k * 2 + customer.get(0);
       for (int i = 0; i < customer.size(); i++) {
            Integer custLoc = customer.get(i);
     //       System.out.println(custLoc + "- " + customerIndx);

            if (custLoc > customerIndx) {
                customerIndx = (k * 2 ) + custLoc;
                hotelsCount++;
                //System.out.println("current cust: "+custLoc+"   customerIndx: "+customerIndx +"   hotelsCount: " + hotelsCount);
            }

        }
    //    System.out.println(hotelsCount);
        return hotelsCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\minH.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\result1.txt"));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int customerCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> customer = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                int k = Integer.parseInt(bufferedReader.readLine().trim());

                int result = solve(customer, k);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
