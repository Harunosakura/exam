/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nesrin
 */
public class MatrixLayerRotation {
        static void matrixRotation(List<List<Integer>> matrix, int r) {
        List<List<Integer>> tempMatrix = new ArrayList<>();
        for (int i = r; i > 0; i--) {
            if(i==r)
                tempMatrix=    singleRotation(matrix);
            else
                tempMatrix = singleRotation(tempMatrix);
        }
//          System.out.println("------------Befor");
//                for (int s = 0; s < matrix.size(); s++) {
//                    for (int t = 0; t < matrix.get(s).size(); t++) {
//                        System.out.print(matrix.get(s).get(t) + "  ");
//                    }
//                    System.out.println("");
//                }
//                System.out.println("------ After");
                for (int s = 0; s < tempMatrix.size(); s++) {
                    for (int t = 0; t < tempMatrix.get(s).size(); t++) {
                        System.out.print(tempMatrix.get(s).get(t) + " ");
                    }
                    System.out.println("");
                }
    }

    static List<List<Integer>> singleRotation(List<List<Integer>> matrix) {
        int depth = 0;
        int[][] arTemp = new int[matrix.size()][matrix.get(0).size()];

        if (matrix.size() % 2 == 0) {
            depth = matrix.size() / 2;
        } else {
            depth = matrix.get(0).size() / 2;
        }
        for (int d = 0; d < depth; d++) {
            //System.out.println(d);
            for (int j = d; j < matrix.size() - d; j++) {
                for (int i = d; i < matrix.get(0).size() - d; i++) {
                    //System.out.println("-- " + matrix.get(j).get(i));
                    if (j == d) {
                        if (i == d) {
                            arTemp[j + 1][i] = matrix.get(j).get(i);
                        } else {
                            arTemp[j][i - 1] = matrix.get(j).get(i);
                        }
                    } else if (j == matrix.size() - 1 - d) {
                        if (i == matrix.get(0).size() - 1 - d) {
                            arTemp[j - 1][i] = matrix.get(j).get(i);
                        } else {
                            arTemp[j][i + 1] = matrix.get(j).get(i);
                        }
                    } else if (i == d && j > d) {
                        arTemp[j + 1][i] = matrix.get(j).get(i);
                    } else if (i == matrix.get(0).size() - 1 - d) {
                        arTemp[j - 1][i] = matrix.get(j).get(i);
                    }
                }
//                System.out.println("------------Befor");
//                for (int s = 0; s < matrix.size(); s++) {
//                    for (int t = 0; t < matrix.get(s).size(); t++) {
//                        System.out.print(matrix.get(s).get(t) + "  ");
//                    }
//                    System.out.println("");
//                }
//                System.out.println("------ After");
//                for (int s = 0; s < arTemp.length; s++) {
//                    for (int t = 0; t < arTemp[0].length; t++) {
//                        System.out.print(arTemp[s][t] + "  ");
//                    }
//                    System.out.println("");
//                }
            }

        }
        List<List<Integer>> tempMatxrix = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
        for (int s = 0; s < arTemp.length; s++) {
          temp = new ArrayList<>();
            for (int t = 0; t < arTemp[0].length; t++) {
                temp.add(arTemp[s][t]);
            }
            tempMatxrix.add(temp);
        }
        return tempMatxrix;
    }


    public static void main(String[] args) {
        //      int[][] ar = {{1, 2, 3, 111}, {4, 5, 6, 12, 222}, {7, 8, 9, 333}, {20,30, 40, 50}, {60, 70, 80, 90}, {10, 11, 12, 444}};
//        int[][] ar = new int[6][6];
//        int ind = 10;
//        for (int i = 0; i < ar.length; i++) {
//            for (int j = 0; j < ar[0].length; j++) {
//                ar[i][j] = ind;
//                ind++;
//                System.out.print(ar[i][j] + "  ");
//            }
//            System.out.println("");
//        }

//        System.out.println("rows: " + ar.length + " cols: " + ar[0].length);
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(i * 6);
            cur.add(i * 6 + 1);
            cur.add(i * 6 + 2);
            cur.add(i * 6 + 3);
            cur.add(i * 6 + 4);
            cur.add(i * 6 + 5);
            matrix.add(cur);

        }
           List<Integer> cur = new ArrayList<>();
            cur.add(100);
            cur.add(101);
            cur.add(102);
            cur.add(103);
            cur.add(104);
            cur.add(105);
            matrix.add(cur);
        //System.out.println(matrix);
        matrixRotation(matrix, 1);
    }
}
