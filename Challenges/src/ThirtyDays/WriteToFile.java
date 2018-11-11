/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirtyDays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Nesrin
 */
public class WriteToFile {

         public static void main(String[] args) throws IOException {
                  BufferedWriter w = new BufferedWriter(new FileWriter("C:\\java\\hr.txt"));

                  for (int i = 0; i < 200000; i++) {
                           if (i > 0)
                                    w.newLine();
                           w.write("1");
                           w.newLine();
                           w.write("breakfast  citycenterlocationmetro view staff price"
                                   + "breakfast beach citycenter  metro view staff price"
                                   + "breakfast beach  location metro  staff price"
                                   + "breakfast beach citycenter location metro view staff price"
                                   + "breakfast beach citycenter  metro view staff price");
                           w.newLine();
                           w.write("2");
                           w.newLine();
                           w.write("breakfast beach citycenterlocationmetro view staff price"
                                   + "breakfast beach citycenter location metro view staff price"
                                   + "breakfast beach citycenter location metro view staff price"
                                   + "breakfast beach citycenter location metro view staff price"
                                   + "breakfast beach citycenter location metro view staff price");
                           w.newLine();
                           w.write("3");
                           w.newLine();
                           w.write("breakfast beach citycenterlocationmetro view staff price"
                                   + "breakfast beach citycenter location metro view staff price"
                                   + "breakfast beach citycenter  metro view staff price"
                                   + "breakfast beach citycenter location metro view staff price"
                                   + "breakfast beach  location metro view staff price");
                           w.newLine();
                           w.write("4");
                           w.newLine();
                           w.write("breakfast beach citycenterlocationmetro view staff price"
                                   + "breakfast beach citycenter location metro view staff price"
                                   + "breakfast beach citycenter location metro view staff price"
                                   + "breakfast beach citycenter location metro view staff price"
                                   + "breakfast beach citycenter location metro view staff price");
                  }
                  w.close();
         }
}
