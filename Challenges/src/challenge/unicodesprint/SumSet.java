package challenge.unicodesprint;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SumSet {
    static  List<List<Integer>> resultArray = new ArrayList<>();
    static List<List<Integer>> sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
       int s = 0;
      
        //   System.out.println(partial);
        s = partial.stream().map((x) -> x).reduce(s, Integer::sum);
       if (s == target && !partial.isEmpty()){
      //      System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
            resultArray.add(partial);
       }
       if (s >= target){
        //   System.out.println(resultArray); 
           return resultArray; 
       }
       for(int i=0;i<numbers.size();i++) {
             ArrayList<Integer> remaining = new ArrayList<>();
             int n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
             ArrayList<Integer> partial_rec = new ArrayList<>(partial);
             partial_rec.add(n);
             System.out.println("partial_rec: "+partial_rec.indexOf(n));
             sum_up_recursive(remaining,target,partial_rec);
       }
       
        return resultArray;
    }
    static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<>());
    }
    public static void main(String args[]) {
        Integer[] numbers = {1,2,3,4,5,8};
        int target = 16;
        sum_up(new ArrayList<>(Arrays.asList(numbers)),target);
        System.out.println(resultArray);
      
        System.out.println(resultArray.size());
    }
}
/*

    static List<List<Integer>> sum_up_recursive(List<Integer> numbers, int target, List<Integer> partial) {
        int s = 0;

        //   System.out.println(partial);
        s = partial.stream().sorted().map((x) -> x).reduce(s, Integer::sum);
        if (s == target && !partial.isEmpty()) {
            //      System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
            resultArray.add(partial);
        }
        if (s >= target) {
            //   System.out.println(resultArray); 
            return resultArray;
        }
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> remaining = new ArrayList<>();
            int n = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                remaining.add(numbers.get(j));
            }
            List<Integer> partial_rec = new ArrayList<>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining, target, partial_rec);
        }

        return resultArray;
    }

    static void sum_up(List<Integer> numbers, int target) {
        sum_up_recursive(numbers, target, new ArrayList<>());
    }

*/