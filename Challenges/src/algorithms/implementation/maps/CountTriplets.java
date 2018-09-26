/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nesrin
 */
public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long cnt = 0;
        Map<Long, Long> map = new HashMap<>();
        Map<Long, Long> rMap = new HashMap<>();
        for (long n : arr) {
            if (n % r == 0) {
                long pre = n / r;
                Long cnt2 = rMap.get(pre);
                //   System.out.println("cnt2: "+cnt2);
                if (cnt2 != null) {
                    cnt += cnt2;
                }
                Long cnt1 = map.get(pre);
                if (cnt1 != null) {
                    rMap.put(n, rMap.getOrDefault(n, 0L) + cnt1);
                }
            }
            map.put(n, map.getOrDefault(n, 0L) + 1);
            System.out.println(rMap);
            System.out.println(map);
        }

        System.out.println(cnt);
        return cnt;
    }

    public static void main(String[] args) {
        List<Long> arr = new ArrayList<>();
        arr.add(1l);
        arr.add(3l);
        arr.add(9l);
        arr.add(9l);
        arr.add(27l);
        arr.add(81l);
        countTriplets(arr, 3);
    }
}
