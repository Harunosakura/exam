package challenge.booking;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class DynamicSearchResults {

    static int movements = 0;
    static List<Integer> indices = null;

    // Complete the solve function below.
    static int solve(List<Integer> list1, List<Integer> list2) {
        movements = 0;
        int list1size = list1.size();
        int list2size = list2.size();
        System.out.println("1- " + LocalDateTime.now().toString());

        List<Integer> list1Common = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
        System.out.println("2- " + LocalDateTime.now().toString());
        
        List<Integer> list2Common = list2.stream()
                .filter(list1Common::contains)
                .collect(Collectors.toList());
        System.out.println("3- " + LocalDateTime.now().toString());

        indices = new ArrayList<>();

        list2Common.stream().forEach(item ->{
            System.out.println("item: "+item);
            System.out.println("Inx in list1 : "+list1Common.indexOf(item));
            indices.add(list1Common.indexOf(item));
                });
        System.out.println(indices);
        System.out.println("4- " + LocalDateTime.now().toString());

        if (list1Common.size() < list1.size()) {
            ++movements;
        }

        List<Integer> y = list2.stream().filter(a -> !(list1Common.contains(a))).collect(Collectors.toList());
        if (!y.isEmpty()) {
            list1Common.add(list2.indexOf(y.get(0)), y.get(0));
            ++movements;
        }
        if (list1Common.size() < list1size) {
            movements += (list1size - list1Common.size());
        }
        if (list1Common.size() < list2size) {
            movements += (list2size - list1Common.size());
        }
        System.out.println(LocalDateTime.now().toString());

        System.out.println("movements = " + movements);
        return movements;
    }
// Function to find length of longest increasing subsequence

    static List<Integer> getIntersectionFromSortedList(List<Integer> arr1, List<Integer> arr2, int m, int n) {
        int i = 0, j = 0;
        List<Integer> x = new ArrayList<>();
        while (i < m && j < n) {
            if (arr1.get(i) < arr2.get(j)) {
                i++;
            } else if (arr2.get(j) < arr1.get(i)) {
                j++;
            } else {
                x.add(arr2.get(j++));
                i++;
            }
        }
//        System.out.println(x.size());
//        System.out.println(x);
        return x;
    }

    public static int lis1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] max = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            max[i] = 1;
            for (int j = 0; j < i; j++) {
                //   System.out.println(nums[i]+", "+ nums[j]);
                if (nums[i] > nums[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < max.length; i++) {
            if (max[i] > result) {
                result = max[i];
            }
        }
        return result;
    }

//    // Program for Longest Increasing Subsequence
//    public static void main1(String[] args) {
//        int[] A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
//
//        System.out.print("Length of LIS is " + lis(A, 0, A.length, Integer.MIN_VALUE));
//    }
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list1.add(i);
        }

        for (int i = 100; i > 0; i -= 3) {
            list2.add(i);
        }

        solve(list1, list2);

    }

    public static void main1(String[] args) throws IOException {
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
