package challenge.booking.exam;





/**
 * Check if an input of int array is a triangle
 *  - array should contain 3 items
 *  - all should be positive or return 0
 *  - summing of every 2 items should be greater than the third one return 2
 *  - if all edges are equal return 1
 * 
 * @author Nesrin
 */
public class Triangle {
    
           
        public static void main(String[] args) {
            System.out.println(triangle(3, 3, 3));
        }
      static int triangle(int a, int b, int c) {
          if(isPositive(a, b, c))
              if(isEqualEdges(a, b, c))
                  return 1;
              else if(isTriangle(a, b, c))
                  return 2;
          return 0;

    }
    private static boolean isPositive(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0;

    }

    private static boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && c + b > a;

    }

    private static boolean isEqualEdges(int a, int b, int c) {
        return a == b && b == c;
    }
}
