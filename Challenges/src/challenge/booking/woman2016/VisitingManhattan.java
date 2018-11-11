/*
https://www.hackerrank.com/contests/booking-womenintech-2017/challenges/visiting-manhattan
 */
package challenge.booking.woman2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

/**
 *
 * @author Nesrin
 */
public class VisitingManhattan {

         public static void main(String[] args) throws IOException  {
                  System.out.println("1 : " + LocalDateTime.now().toString());
                  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//                  BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\vm21.txt")));
                  String[] t = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                  int x = Integer.parseInt(t[0]);
                  int y = Integer.parseInt(t[1]);
                  int l = Integer.parseInt(t[2]);
                  int h = Integer.parseInt(t[3]);
                  int[] masX = new int[100001];
                  long[] cX = new long[100001];
                  long[] cCX = new long[100001];
                  int[] masY = new int[100001];
                  long[] cY = new long[100001];
                  long[] cCY = new long[100001];
                  for (int i = 1; i <= l; i++) {
                           String ss = bufferedReader.readLine().replaceAll("\\s+$", "");
                           String[] tt = ss.split(" ");
                           int cordX = Integer.parseInt(tt[0]);
                           int cordY = Integer.parseInt(tt[1]);

                           masX[cordX] = masX[cordX] + 1;
                           masY[cordY] = masY[cordY] + 1;
                  }

                  long tempCX = 0;
                  long tempCY = 0;
                  long tCX = 0;
                  long tCY = 0;

                  for (int i = 1; i < 100001; i++) {
                           cX[i] = tCX + masX[i];
                           tCX = cX[i];
                           cCX[i] = tempCX + i * masX[i];
                           tempCX = cCX[i];

                           cY[i] = tCY + masY[i];
                           tCY = cY[i];
                           cCY[i] = tempCY + i * masY[i];
                           tempCY = cCY[i];
                  }

                  long minDic = Long.MAX_VALUE;
                  int nHotel = 0;

                  for (int i = 1; i <= h; i++) {
                           String sss = bufferedReader.readLine().replaceAll("\\s+$", "");
                           String[] tt = sss.split(" ");
                           int xh = Integer.parseInt(tt[0]);
                           int yh = Integer.parseInt(tt[1]);
                           long tempX = cCX[xh - 1] - xh * cX[xh - 1] + xh * (cX[100000] - cX[xh - 1]) - cCX[100000] + cCX[xh - 1];
                           long tempY = cCY[yh - 1] - yh * cY[yh - 1] + yh * (cY[100000] - cY[yh - 1]) - cCY[100000] + cCY[yh - 1];

                           tempX = Math.abs(tempX);
                           tempY = Math.abs(tempY);

                           long tempD = tempX + tempY;
                           if (tempD < minDic) {
                                    minDic = tempD;
                                    nHotel = i;
                           }
                  }
                  System.out.println(nHotel);
         }

}
