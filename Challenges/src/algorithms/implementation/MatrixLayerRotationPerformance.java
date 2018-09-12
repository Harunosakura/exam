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
public class MatrixLayerRotationPerformance {
    // Complete the matrixRotation function below.

    static void matrixRotation(List<List<Integer>> matrix, int r) {
        Integer[][] arTemp = new Integer[matrix.size()][matrix.get(0).size()];

        for (int s = 0; s < arTemp.length; s++) {
            for (int t = 0; t < arTemp[0].length; t++) {
                arTemp[s][t] = matrix.get(s).get(t);
            }
        }
        for (int i = r; i > 0; i--) {
            arTemp = singleRotation(arTemp, r, i);
        }
        for (int s = 0; s < arTemp.length; s++) {
            for (int t = 0; t < arTemp[0].length; t++) {
                System.out.print(arTemp[s][t] + "  ");
            }
            System.out.println("");
        }
    }

    static Integer[][] singleRotation(Integer[][] ar, int r, int current) {
        int depth;
        Integer[][] arTemp = new Integer[ar.length][ar[0].length];
        if (ar.length % 2 == 0) {
            depth = ar.length / 2;
        } else {
            depth = ar[0].length / 2;
        }
        for (int d = 0; d < depth; d++) {
            for (int j = d; j < ar.length - d; j++) {
                for (int i = d; i < ar[0].length - d; i++) {
                    if (j == d) {
                        if (i == d) {
                            arTemp[j + 1][i] = ar[j][i];
                        } else {
                            arTemp[j][i - 1] = ar[j][i];
                        }
                    } else if (j == ar.length - 1 - d) {
                        if (i == ar[0].length - 1 - d) {
                            arTemp[j - 1][i] = ar[j][i];
                        } else {
                            arTemp[j][i + 1] = ar[j][i];
                        }
                    } else if (i == d && j > d) {
                        arTemp[j + 1][i] = ar[j][i];
                    } else if (i == ar[0].length - 1 - d) {
                        arTemp[j - 1][i] = ar[j][i];
                    }
                }
            }
        }
        return arTemp;
    }

    public static void main(String[] args) {

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
        matrixRotation(matrix, 5);
    }
}
