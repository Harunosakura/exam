package challenge.unicodesprint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Nesrin
 */
public class ArrayTriplets {

    static List<List<Integer>> resultArray;
    static int resultVal;

    static int solve(List<Integer> a) {
        Collections.sort(a);
        int target = a.stream().mapToInt(x -> x).sum() / 3;

        if (identicalList(a)) {
            return factrial(a.size());
        } else {
            resultArray = new ArrayList<>();
        }
        System.out.println("resultArray: " + resultArray);
        System.out.println("resultArray: " + resultArray.size());

        return resultVal;
    }

    static List<Integer> collectedItemList(int currentIndexVal, int currentVal, List<Integer> a, List<Integer> internal, int target) {
        
        System.out.println("indx: " + currentIndexVal + " cv: " + currentVal + " a[i]: " + a.get(currentIndexVal) + " a[i+1]: " + a.get(currentIndexVal + 1));
        System.out.println("a: "+a);
        
        if(internal.stream().mapToInt(x->x).sum()==target)
            return internal;
      
        for (int i = currentIndexVal; i < a.size(); i++) {
            if (summing(currentVal , a.get(i + 1) , target) == target) {
                if (internal.isEmpty()) {
                    internal.add(currentVal);
                    internal.add(a.get(i + 1));
                    System.out.println("1: " + internal);
                    return internal;
                } else {
                    internal.add(currentVal);
                    System.out.println("2: " + internal);
                    return internal;
                }
            } else if (currentVal + a.get(i + 1) < target) {
                if (internal.isEmpty()) {
                    internal.add(currentVal);
                    internal.add(a.get(i + 1));
                    System.out.println("3: " + internal);

                } else {
                    internal.add(a.get(i + 1));
                    System.out.println("4: " + internal);

                }
                internal = collectedItemList(i + 1, currentVal + a.get(i + 1), a, internal, target);
                System.out.println("5: " + internal);

            } else {
                internal.clear();
                System.out.println(internal);
                System.out.println("6: " + internal);

                break;
            }
        }
        return internal;

    }
    private static int summing(int a, int b, int target){
        if(a+b ==target)
            return 0;
        else if(a+b <target)
            return 1;
        else
            return 2;
    }
    private static boolean identicalList(List<Integer> a) {
        for (int i = 0; i < a.size() - 1; i++) {
            if (!a.get(i).equals(a.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    private static int factrial(int size) {
        int fact = 1;
        for (int i = size; i > 0; i--) {
            fact *= i;
        }
        return resultVal += fact;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7};
        //  int x = solve(Arrays.asList(numbers));
        System.out.println(collectedItemList(0, 1, Arrays.asList(numbers), new ArrayList(), 10));
        //System.out.println(x);
    }

}
