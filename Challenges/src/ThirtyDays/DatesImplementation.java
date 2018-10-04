/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirtyDays;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;

/**
 *
 * @author Nesrin
 */
public class DatesImplementation {
         private static LocalDateTime startDate = LocalDateTime.of(2016, Month.JUNE, 15, 0, 0);
         private static LocalDateTime endDate = LocalDateTime.of(2016, Month.JULY, 15, 0, 0);

         public static void main(String[] args) {
                  System.out.println(startDate);
                  System.out.println(startDate.toEpochSecond(ZoneOffset.UTC));
                  System.out.println(endDate.toEpochSecond(ZoneOffset.UTC));
//                LocalDateTime  startDate =  LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTimestamp),
//                                  ZoneOffset.UTC);
//                LocalDateTime  endDate =  LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTimestamp),
//                                  ZoneOffset.UTC);
         }
}
