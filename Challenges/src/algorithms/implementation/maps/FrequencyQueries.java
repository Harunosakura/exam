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
public class FrequencyQueries {

    static List<Integer> freqQuery(List<int[]> queries) {

        final Map<Integer, Integer> valueToFreq = new HashMap<>();
        final Map<Integer, Integer> freqToOccurrence = new HashMap<>();
        final List<Integer> frequencies = new ArrayList<>();

        int key;
        int value;
        Integer oldFreq;
        Integer newFreq;
        Integer oldOccurrence;
        Integer newOccurrence;
        for (int[] query : queries) {
            key = query[0];
            value = query[1];
            if (key == 3) {
                if (value == 0) {
                    frequencies.add(1);
                }
                frequencies.add(freqToOccurrence.get(value) == null ? 0 : 1);
            } else {
                oldFreq = valueToFreq.get(value);
                oldFreq = oldFreq == null ? 0 : oldFreq;
                oldOccurrence = freqToOccurrence.get(oldFreq);
                oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;

                if (key == 1) {
                    newFreq = oldFreq + 1;
                } else {
                    newFreq = oldFreq - 1;
                }
                newOccurrence = freqToOccurrence.get(newFreq);
                newOccurrence = newOccurrence == null ? 0 : newOccurrence;

                if (newFreq < 1) {
                    valueToFreq.remove(value);
                } else {
                    valueToFreq.put(value, newFreq);
                }

                if ((oldOccurrence - 1) < 1) {
                    freqToOccurrence.remove(oldFreq);
                } else {
                    freqToOccurrence.put(oldFreq, oldOccurrence - 1);
                }
                freqToOccurrence.put(newFreq, newOccurrence + 1);
            }
        }
        return frequencies;
    }

    static List<Integer> freqQuery1(List<List<Integer>> queries) {
        List<Integer> res = new ArrayList<>();
        int index = 0;
        Map<Long, Long> collectCount = new HashMap<>();
        for (List<Integer> query : queries) {
            long val = query.get(1);
            switch (query.get(0)) {
                case 1:
                    collectCount.put(val, collectCount.getOrDefault(val, 0l) + 1);
                    break;
                case 2:
                    Long v = collectCount.get(val);
                    if (v != null && v > 1) {
                        collectCount.put(val, collectCount.getOrDefault(val, 0l) - 1);
                    } else {
                        collectCount.remove(val);
                    }
                    break;
                case 3:
                    index++;
                    if (collectCount.containsValue(val)) {
                        res.add(1);
                    } else {
                        res.add(0);
                    }
                    break;
//                    for (Map.Entry<Long, Long> entry : collectCount.entrySet()) {
//                        if (entry.getValue() == val) {
//                            res.add(1);
//                            break;
//                        }
//                    }
//                    if(index>res.size())
//                        res.add(0);
//                    break;
                default:
                    break;
            }
        }
        return res;
    }

    static List<Integer> freqQuery2(List<int[]> queries) {

        List<Integer> res = new ArrayList<>();
        int index = 0;
        Map<Long, Long> collectCount = new HashMap<>();
        for (int i = 0; i < queries.size(); i++) {
            long val = queries.get(i)[1];
            switch (queries.get(i)[0]) {
                case 1:
                    collectCount.put(val, collectCount.getOrDefault(val, 0l) + 1);
                    break;
                case 2:
                    Long v = collectCount.get(val);
                    if (v != null && v > 1) {
                        collectCount.put(val, collectCount.getOrDefault(val, 0l) - 1);
                    } else {
                        collectCount.remove(val);
                    }
                    break;
                case 3:
                    if (collectCount.containsValue(val)) {
                        res.add(1);
                    } else {
                        res.add(0);
                    }
                    break;
                default:
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 3}, {2, 3}, {2, 3}, {3, 2}, {1, 4}, {1, 5}, {1, 5}, {1, 4}, {3, 2}, {2, 4}, {3, 2}};
        List<int[]> list = new ArrayList<>();
        for (int[] array : x) {
            //     List<Integer> collect = Arrays.stream(array).collect(Collectors.toList());
            //      System.out.println(collect);
            list.add(array);
        }
        freqQuery(list);
    }
}
