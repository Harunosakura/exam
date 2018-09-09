/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Nesrin
 */
public class MigratoryBirds {
    // Complete the migratoryBirds function below.

    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Long> nameCount = arr.stream().sorted().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
//        nameCount.forEach((name, count) -> {
//            System.out.println(name + ":" + count);
//        });
//        System.out.println(x);
        return  nameCount.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    public static void main(String[] args) {
        Integer[] ar = {1, 4, 4, 4, 5, 3,3,3};
        System.out.println(migratoryBirds(Arrays.asList(ar)));
    }
}
