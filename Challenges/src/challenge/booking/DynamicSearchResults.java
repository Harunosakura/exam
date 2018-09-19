package challenge.booking;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class DynamicSearchResults {

    static List<Integer> indices = null;

    // Complete the solve function below.
    static int solve(List<Integer> list1, List<Integer> list2) {
        int movements = 0;
        List<Integer> filter1 = list1;//list1.stream().filter(s -> s >= 0 && s<=100000000 ).collect(Collectors.toList());
        List<Integer> filter2 = list2;//list2.stream().filter(s -> s >= 0&& s<=100000000 ).collect(Collectors.toList());

        int list1size = filter1.size();
        int list2size = filter2.size();
//        System.out.println("1- " + LocalDateTime.now().toString());

        Map<Integer, Integer> keyList1 = new HashMap<>();
        for (int i = 0; i < list1size; i++) {
            int x = filter1.get(i);
            if (x >= 0) {
                keyList1.put(x, i);
            }
        }
//        System.out.println("2- " + LocalDateTime.now().toString());
        Map<Integer, Integer> keyList2 = new HashMap<>();
        for (int i = 0; i < list2size; i++) {
            Integer x = keyList1.get(filter2.get(i));
            if (x != null) {
                keyList2.put(i, x);
            }
        }

//        System.out.println(keyList1.size());
//        System.out.println(keyList1);
//        System.out.println(keyList2.size());
//        System.out.println(keyList2);
//
//        System.out.println("3- " + LocalDateTime.now().toString());
//        int previousIndex = -1;
//        for (Map.Entry<Integer, Integer> entry : keyList2.entrySet()) {
////            System.out.println("entry.getValue()  : " + entry.getValue() + " previousIndex: " + previousIndex);
//
//            if (previousIndex == -1) {
//                previousIndex = entry.getValue();
//            } else if (entry.getValue() < previousIndex) {
//                movements++;
//            }
//
//            previousIndex = entry.getValue();
//        }
//        System.out.println("Trans : " + movements);

        if (keyList2.size() < list1size) {
            movements += (list1size - keyList2.size());
//            System.out.println("Remove : " + movements);
        }
        if (keyList2.size() < list2size) {
            movements += (list2size - keyList2.size());
//            System.out.println("Add : " + movements);

        }
//        System.out.println(LocalDateTime.now().toString());
//
//        System.out.println("movements = " + movements);
        return movements;
    }

    public static int increasingSubsequence(int[] seq) {
        int[] L = new int[seq.length];
        L[0] = 1;
        for (int i = 1; i < L.length; i++) {
            int maxn = 0;
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && L[j] > maxn) {
                    maxn = L[j];
                }
            }
            L[i] = maxn + 1;
        }
        int maxi = 0;
        for (int i = 0; i < L.length; i++) {
            if (L[i] > maxi) {
                maxi = L[i];
            }
        }
        return (maxi);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\list0.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\result1.txt"));
        String[] nm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nm[0]);
        if (n < 1 || n > 200000) {
            throw new RuntimeException("Number Range Exception");
        }
        int m = Integer.parseInt(nm[1]);
        if (m < 1 || m > 200000) {
            throw new RuntimeException("Number Range Exception");
        }
        List<Integer> list1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> list2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = solve(list1, list2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
