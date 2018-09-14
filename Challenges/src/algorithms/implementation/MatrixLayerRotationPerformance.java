/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Nesrin
 */
public class MatrixLayerRotationPerformance {
    // Complete the matrixRotation function below.

    static void matrixRotation(List<List<Integer>> matrix, int r) {
        allRotationsList(matrix, r);
    }

    static void allRotationsList(List<List<Integer>> matrix, int r) {
        int depth;
        boolean rowsSize = false;
        boolean colSize = false;
        int rowsListSize = matrix.size();
        int colsListSize = matrix.get(0).size();
        if (rowsListSize % 2 == 0) {
            rowsSize = true;
        }
        if (matrix.get(0).size() % 2 == 0) {
            colSize = true;
        }
        if (rowsSize && colSize) {
            depth = Math.min(rowsListSize, colsListSize) / 2;
        } else if (rowsSize) {
            depth = rowsListSize / 2;
        } else {
            depth = matrix.get(0).size() / 2;
        }
        List<Integer> singleList;

//        for (int s = 0; s < rowsListSize; s++) {
//            for (int t = 0; t < matrix.get(s).size(); t++) {
//                System.out.print(matrix.get(s).get(t) + " ");
//            }
//            System.out.println("");
//        }
        List<List<Integer>> allRotations = new ArrayList<>();
        for (int j = 0; j < depth; j++) {
            singleList = new ArrayList<>();
            for (int i = j; i < colsListSize - j; i++) {
                singleList.add(matrix.get(j).get(i));
            }
            for (int i = j; i < rowsListSize - j - 1; i++) {
                singleList.add(matrix.get(i + 1).get(colsListSize - 1 - j));
            }
            for (int i = colsListSize - 1 - j; i > j; i--) {
                singleList.add(matrix.get(rowsListSize - 1 - j).get(i - 1));
            }
            for (int i = rowsListSize - j - 2; i > j; i--) {
                singleList.add(matrix.get(i).get(j));
            }
            Collections.rotate(singleList, -r);
         //   System.out.println(singleList);
            allRotations.add(singleList);
        }
        fillFinalMatrix(allRotations, rowsListSize, colsListSize, depth);

    }

    static void fillFinalMatrix(List<List<Integer>> matrix, int rows, int cols, int depth) {
        Integer[][] ordered = new Integer[rows][cols];
        for (int matrixRows = 0; matrixRows < matrix.size(); matrixRows++) {
            List<Integer> matrixRow = matrix.get(matrixRows);
            int currCol = -1 + matrixRows;
            int currRow = matrixRows;
            int flatArraySize = matrixRow.size();

            for (int i = 0; i < matrixRow.size(); i++) {
                // rows 8, cols 4
                // till i ==3
                if (i < cols) {
                    currCol++;
                    // from i =4 till i <(8+4-1)  i.e i =10
                } else if (i >= cols && i < (rows + cols-1)) {
                    currRow++;
                    // i>=11        //8 +4-1 =11        // till i < (24-8) i.e till i=15      
                } else if (i >= (rows + cols-1) &&  currCol>0+matrixRows) {
                    currCol--;
                } else {
                    currRow--;
                }
               // System.out.println("flatArraySize: "+ flatArraySize+"  currRow: " + currRow + " currCol: " + (currCol) + "   vl:" + matrixRow.get(i));

                ordered[currRow][currCol] = matrixRow.get(i);
//                for (int s = 0; s < ordered.length; s++) {
//                    for (int t = 0; t < ordered[0].length; t++) {
//                        System.out.print(ordered[s][t] + " ");
//                    }
//                    System.out.println("");
//                }
//                System.out.println("-----------------");

            }
            rows -= 2;
            cols -= 2;

        }
                     //   System.out.println("-----------------");

        for (int i = 0; i < ordered.length; i++) {
            for (int j = 0; j < ordered[0].length; j++) {
                System.out.print(ordered[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static void singleRotationArray(List<List<Integer>> matrix, int r) {
        int depth;
        boolean rowsSize = false;
        boolean colSize = false;
        if (matrix.size() % 2 == 0) {
            rowsSize = true;
        }
        if (matrix.get(0).size() % 2 == 0) {
            colSize = true;
        }
        if (rowsSize && colSize) {
            depth = Math.min(matrix.size(), matrix.get(0).size());
        } else if (rowsSize) {
            depth = matrix.size() / 2;
        } else {
            depth = matrix.get(0).size() / 2;
        }
        Integer[][] flatArray = new Integer[depth][((matrix.size() + matrix.get(0).size()) * 2) - 2];
        Integer[] singlelayer = null;
        int rowsListSize = matrix.size();
        int colsListSize = matrix.get(0).size();
        //   for (int i = 0; i < matrix.size(); i++) {
        for (int s = 0; s < matrix.size(); s++) {
            for (int t = 0; t < matrix.get(s).size(); t++) {
                System.out.print(matrix.get(s).get(t) + " ");
            }
            System.out.println("");
        }
        for (int j = 0; j < depth; j++) {
            System.out.println("j: " + j);
            singlelayer = new Integer[flatArray[0].length];
            for (int i = j; i < colsListSize - j; i++) {
                singlelayer[i] = matrix.get(j).get(i);
                System.out.print(singlelayer[i] + " ");
            }
            //System.out.println("singlelayer:");
            for (int i = j; i < rowsListSize - j - 1; i++) {
                singlelayer[i + colsListSize] = matrix.get(i + 1).get(colsListSize - 1 - j);
                System.out.print(singlelayer[i + colsListSize] + " ");
            }
            for (int i = colsListSize - 1 - j; i > j; i--) {
                singlelayer[rowsListSize + colsListSize + i] = matrix.get(rowsListSize - 1 - j).get(i - 1);
                System.out.print(singlelayer[rowsListSize + colsListSize + i] + " ");
            }
            for (int i = rowsListSize - j - 2; i > j; i--) {
                singlelayer[i + colsListSize] = matrix.get(i).get(j);
                System.out.print(singlelayer[i + colsListSize] + " ");
            }
            System.out.println("");
            System.out.println("j: " + j);

        }
    }

    static Integer[][] singleRotation(Integer[][] ar, int r, int current) {
        int depth;
        boolean rowsSize = false;
        boolean colSize = false;
        if (ar.length % 2 == 0) {
            rowsSize = true;
        }
        if (ar[0].length % 2 == 0) {
            colSize = true;
        }
        if (rowsSize && colSize) {
            depth = Math.min(ar.length, ar[0].length);
        } else if (rowsSize) {
            depth = ar.length / 2;
        } else {
            depth = ar[0].length / 2;
        }

        int d = 0;
        Integer[][] flatArray = new Integer[depth][((ar.length + ar[0].length) * 2) - 2];

        for (int i = 0; i < depth; i++) {
            int minPoint = i;
            int maxPoint = ar.length - i;
            Integer[] singlelayer = new Integer[flatArray[0].length];
            for (int rows = 0; rows < ar.length; rows++) {
                // singlelayer[rows]
            }
            for (int cols = 0; cols < ar[0].length; cols++) {

            }
        }
        for (int rows = 0; rows < ar.length; rows++) {
            for (int cols = rows; cols < ar[0].length; cols++) {
                if (cols == ar[0].length - 1 - d) {

                }
            }
            d++;
        }

        Integer[][] arTemp = null;

        return arTemp;
    }

    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(i * 6);
            cur.add(i * 6 + 1);
            cur.add(i * 6 + 2);
//            cur.add(i * 6 + 3);
//            cur.add(i * 6 + 4);
//            cur.add(i * 6 + 5);
            matrix.add(cur);

        }
        List<Integer> cur = new ArrayList<>();
//        cur.add(100);
//        cur.add(101);
//        cur.add(102);
//        cur.add(103);
//        cur.add(104);
//        cur.add(105);
//        matrix.add(cur);
//        cur = new ArrayList<>();
//        cur.add(200);
//        cur.add(201);
//        cur.add(202);
//        cur.add(203);
//        cur.add(204);
//        cur.add(205);
//        matrix.add(cur);
    
        matrixRotation(matrix, 1);
    }
}
