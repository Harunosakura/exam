
package rev.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Check each line of an String array input. <br>
 * The requirement is to calculate how many Squares, Rectangles, then Others are
 * there in the array <br>
 * - each line is a 4 integers separated by space <br>
 * - the 4 integers should represent a type of polygon <br>
 * - all should be positive <br>
 * - if 4 sides are equal consider a square <br>
 * - if each 2 sides are consider as rectangle <br>
 *
 * @author Nesrin
 *
 */

public class Polygon {
    /**
     * @param  lines is an input for testing<br>
     * Expected output  is "2 2 3"
     */
    static String[] lines = {
        "36 30 36 30",
        "15 15 15 15",
        "46 96 90 100",
        "86 86 86 86",
        "100 200 100 200",
        "-100 200 1000 200",
        "-100 200 200"};

    public static void main(String[] args) {
        polygonCheck();
    }

    enum ShapesConst {
        SQUARE, RECTANGLE, OTHER;
    }

    static void polygonCheck() {

        List<ShapesConst> resultShapeArray = new ArrayList<>();

        for (String line : lines) {

            int[] borders = Arrays.stream(line.split(" "))
                    .mapToInt(border ->Integer.valueOf(border)).toArray();
            
            if(checkPolygonSides(borders))
               if(isSquare(borders)) resultShapeArray.add(ShapesConst.SQUARE);
               else if (isRecatngle(borders)) resultShapeArray.add(ShapesConst.RECTANGLE);
               else  resultShapeArray.add(ShapesConst.OTHER);
            else
                resultShapeArray.add(ShapesConst.OTHER);
     
             
        }
          System.out.println(resultShapeArray.stream().filter(type -> type ==ShapesConst.SQUARE).count()
                    +" " +resultShapeArray.stream().filter(type -> type ==ShapesConst.RECTANGLE).count()
                    +" " +resultShapeArray.stream().filter(type -> type ==ShapesConst.OTHER).count()            
            );
    }

    static boolean checkPolygonSides(int[] borders) {
        if (borders.length != 4) 
            return false;
        
        if (Arrays.stream(borders).anyMatch(val -> Math.abs(val) >= 2000)) 
            throw new RuntimeException("Value of Side is out of acceptable range");
        
        return true;
    }

    static boolean isRecatngle(int[] borders) {
        return borders[0] == borders[2] && borders[1] == borders[3];
    }

    static boolean isSquare(int[] borders) {
        return borders[0] == borders[1] && borders[1] == borders[2] && borders[2] == borders[3];
    }
}
