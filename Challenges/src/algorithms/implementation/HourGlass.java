/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation;

/**
 *
 * @author Nesrin
 */
public class HourGlass {

    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[0].length - 2; j++) {
                //  System.out.println(arr[i][j]+" "+arr[i][j+1]+" "+arr[i][j+2]+" "+arr[i+1][j+1]+" "+arr[i+2][j]+" "+arr[i+2][j+1]+" "+arr[i+2][j+2]);
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                if (sum > max) {
                    max = sum;
                }
            }
         //   System.out.println("");
        }
        return max;

    }

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = i + j * 5;
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println("");
        }

        System.out.println(hourglassSum(arr));
    }
}
