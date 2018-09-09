package challenge.booking;




import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nesrin
 */
public class DeltaEncoding {

    static int[] getDiffrence(int[] array) {

        if (array.length == 0) {
            throw new RuntimeException("List Should Contain at Least Single Value");
        }
        List<Integer> x = new LinkedList<>();
        x.add(array[0]);
        int index = 0;
       for (int i = 1; i < array.length; i++) {
            if (index == array.length) {
                break;
            }
            int diffValue = array[i] - array[i-1];
            if (diffValue >= 127 || diffValue <= -127) {
                x.add(-128);
            }
            x.add(diffValue);
        }
        return x.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] inputList = {25626,
            25757,
            24367,
            24267,
            16,
            100,
            2,
            7277};

        System.out.println(Arrays.toString(getDiffrence(inputList)));
    }

}
