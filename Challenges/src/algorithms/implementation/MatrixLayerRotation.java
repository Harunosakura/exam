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
public class MatrixLayerRotation {

    public static void main(String[] args) {
        int[][] ar = {{1, 2, 3, 111}, {4, 5, 6, 12, 222}, {7, 8, 9, 333}, {10, 11, 12, 444}};
        System.out.println(ar[0][0] +"  "+ar[0][1] +"  "+ar[0][2] );
        System.out.println(ar[1][0] +"  "+ar[1][1] +"  "+ar[1][2] );
        System.out.println(ar[2][0] +"  "+ar[2][1] +"  "+ar[2][2] );
        System.out.println(ar[3][0] +" "+ar[3][1] +" "+ar[3][2] );

        System.out.println("rows: "+ar.length+" cols: "+ar[0].length);
         int[][] arTemp = new int[ar.length][ar[0].length];
        int x=0;
        boolean rowsAreEven = false;
        if(ar.length%2==0){
            x = ar.length/2;
            rowsAreEven = true;
        }
        else
             x = ar[0].length/2;
        for (int depth = 0; depth < 1; depth++) {
            for (int j = (rowsAreEven?depth:0); j < ar.length; j++) {
                for (int i = (!rowsAreEven?depth:0); i < ar[0].length; i++) {
                 if(rowsAreEven)
                    if( j<=x)
                        if(i==0)
                            arTemp[j+1][i] = ar[j][i] ;
                        else
                            arTemp[j][i-1] = ar[j][i] ;
                    else
                        if(i==ar[0].length-1)
                             arTemp[j-1][i] = ar[j][i] ;
                        else
                             arTemp[j][i+1] = ar[j][i] ;
                }
       System.out.println(arTemp[0][0] +"  "+arTemp[0][1] +"  "+arTemp[0][2] );
        System.out.println(arTemp[1][0] +"  "+arTemp[1][1] +"  "+arTemp[1][2] );
        System.out.println(arTemp[2][0] +"  "+arTemp[2][1] +"  "+arTemp[2][2] );
        System.out.println(arTemp[3][0] +" "+arTemp[3][1] +" "+arTemp[3][2] );
                
            }
        }
 
    }
}
