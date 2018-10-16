package algorithms.implementation.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwoTwo {

         static int twoTwo(String text) {
                  int len = text.length();
                  int power = 0;
//                  for (int j = 0; j < len; j++)
//                           for (int sub = 1; sub <= len - j; sub++) {
//                                    String subPart = text.substring(j, j + sub);
//                                    if (!subPart.startsWith("0")
//                                            && (subPart.endsWith("2")
//                                                        || subPart.endsWith("4")
//                                                        || subPart.endsWith("6")
//                                                        || subPart.endsWith("8")
//                                                        || subPart.endsWith("0")
//                                            )) {
//                                             Long parsed = Math.round((Double.parseDouble(subPart)));
//                                             if ((parsed & (parsed - 1)) == 0)
//                                                      power++;
//                                    }
//                           }

                  System.out.println(power);
                  return power;
         }
//         private static final Scanner scanner = new Scanner(System.in);
         static List<String> powersString = new ArrayList<>();

         public static void main(String[] args) throws IOException {
                  BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\two.txt")));
                  int t = Integer.parseInt(bufferedReader.readLine().trim());
                  int exponent = 801;
                  int base = 2;
                  power(base, exponent);

                  for (int i = 0; i < t; i++) {
                           String line = bufferedReader.readLine().trim();
                           checkGroupsCount(line);
                  }
         }
         static final int MAX = 100000;

         // This function multiplies x 
         // with the number represented by res[]. 
         // res_size is size of res[] or 
         // number of digits in the number 
         // represented by res[]. This function 
         // uses simple school mathematics 
         // for multiplication. 
         // This function may value of res_size 
         // and returns the new value of res_size 
         static int multiply(int x, int[] res, int res_size) {

                  // Initialize carry 
                  int carry = 0;

                  // One by one multiply n with 
                  // individual digits of res[] 
                  for (int i = 0; i < res_size; i++) {
                           int prod = res[i] * x + carry;
//                           System.out.println(prod + " p");
                           // Store last digit of 
                           // 'prod' in res[] 
                           res[i] = prod % 10;

                           // Put rest in carry 
                           carry = prod / 10;
                  }

                  // Put carry in res and 
                  // increase result size 
                  while (carry > 0) {
                           res[res_size] = carry % 10;
                           carry = carry / 10;
                           res_size++;
                  }
                  String sb = new String();
                  for (int i = res_size - 1; i >= 0; i--)
                           sb = sb + res[i];
                  powersString.add(sb);
                  System.out.println(powersString.get(powersString.size() - 1));
                  return res_size;
         }

         // This function finds 
         // power of a number x 
         static void power(int x, int n) {
                  int res[] = new int[MAX];
//                  List<Integer> res = new ArrayList<>();
                  int res_size = 0;
                  int temp = x;

                  // Initialize result 
                  while (temp != 0) {
                           res[res_size++] = temp % 10;
                           temp = temp / 10;
                  }
                  // Multiply x n times 
                  // (x^n = x*x*x....n times) 
                  for (int i = 2; i <= n; i++)
                           res_size = multiply(x, res, res_size); //                           System.out.println("res_size: " + res_size);
                  //                           System.out.println("res: " + res[2]);
                  //                           System.out.println("x: " + x);
                  //      System.out.print(x + "^" + n + " = ");
                  //   System.out.println(powersString);
         }

//         private static void preparingData() {
//                  int i = 1;
//                  int x = 1;
//                  System.out.println(Double.MAX_VALUE);
//                  while (x <= Double.MAX_VALUE)
//                           if (x > 0) {
//                                    x = 2 << i;
//                                    powersString.add(String.valueOf(Math.abs(x)));
//                                    i++;
//                           } else
//                                    break;
//
//                  //Long.MAX_VALUE;
//         }
         static int index = 0;

         private static void checkGroupsCount(String line) {
                  for (int i = powersString.size() - 1; i >= 0; i--) {
                           Pattern p = Pattern.compile(".*\\d" + powersString.get(i) + ".*\\d");
                           Matcher m = p.matcher(line);
                           if (m.matches())
                                    System.out.println(++index +" "+ powersString.get(i));
                  }

         }
}
