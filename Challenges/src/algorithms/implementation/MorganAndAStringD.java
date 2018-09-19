/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author Nesrin
 */
public class MorganAndAStringD {

    public static void main(String[] args) throws IOException {
//        morganAndString("JACK", "DANIEL");
        System.out.println(morganAndString("YRYVSH", "YRYVSN"));
        System.out.println(morganAndString("YZYYZYZYY", "ZYYZYZYY"));
//        morganAndString("ABACABA", "ABACABA");
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\java\\morgan.txt")));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\java\\result1.txt"));
//        //bufferedReader.readLine().trim();
//        //  int t = scanner.nextInt();
//        System.out.println(LocalDateTime.now().toString());
//        BufferedReader readResult = new BufferedReader(new FileReader(new File("C:\\java\\morR.txt")));
//
//        for (int i = 0; i < 5; i++) {
//            String a = bufferedReader.readLine().trim();
//            String b = bufferedReader.readLine().trim();
//            String result = morganAndString(a, b);
//            String req = readResult.readLine().trim();
//            System.out.println(req.equals(result));
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
//            System.out.println(i+" Main");
//        }
//        System.out.println(LocalDateTime.now().toString());
//        bufferedWriter.close();

    }
static String morganAndString(String a, String b) {
        String res = "";
        boolean stop = false;
        int istop = 0;
        int ia = 0;
        int ib = 0;
        int i = 1;
        
        a = a + (char)( (int)'Z' + 1 );
        b = b + (char)( (int)'Z' + 1 );
        
        while(true){
            if(ia >= a.length()-1){
                if(ib >= b.length()-1){
                    break;
                }
                else{
                    res = res.concat(b.substring(ib, b.length()-1));
                    break;
                }
            }
            else if(ib >= b.length()-1){
                res = res.concat(a.substring(ia, a.length()-1));
                break;
            }
            else if(a.charAt(ia) < b.charAt(ib)){
                while(a.charAt(ia+i) < b.charAt(ib)) {i++;}
                res = res.concat(a.substring(ia,ia+i));
                ia += i;
            }
            else if(a.charAt(ia) > b.charAt(ib)){
                while(a.charAt(ia) > b.charAt(ib+i)) {i++;}
                res = res.concat(b.substring(ib,ib+i));
                ib += i;
            }
            else{
                while(true){
                    if(ia + i >= a.length()){
                        if(stop){
                            res = res.concat(a.substring(ia,ia+istop));
                            ia += istop;
                        }
                        else{
                            res = res.concat(a.substring(ia,a.length()-1));
                            ia += i;
                        } 
                        break;
                    }
                    else if(ib + i >= b.length()){
                        if(stop){
                            res = res.concat(b.substring(ib,ib+istop));
                            ib += istop;
                        }
                        else{
                            res = res.concat(b.substring(ib,b.length()-1));
                            ib += i;
                        }
                        break;
                    }
                    else if(a.charAt(ia+i) < b.charAt(ib+i)){
                        if(stop){
                            res = res.concat(a.substring(ia,ia+istop));
                            ia += istop;
                        }
                        else{
                            res = res.concat(a.substring(ia,ia+i));
                            ia += i;
                        }
                        break;
                    }
                    else if(a.charAt(ia+i) > b.charAt(ib+i)){
                        if(stop){
                            res = res.concat(b.substring(ib,ib+istop));
                            ib += istop;
                        }
                        else{
                            res = res.concat(b.substring(ib,ib+i));
                            ib += i;
                        }
                        break;
                    }
                    else if(a.charAt(ia-1+i) < a.charAt(ia+i)){
                        if(!stop && a.charAt(ia+i) >= b.charAt(ib)) {
                            istop = i;
                            stop = true;
                        }
                    }
                    else if(b.charAt(ib-1+i) < b.charAt(ib+i)){
                        if(!stop && b.charAt(ib+i) >= a.charAt(ia)) {
                            istop = i;
                            stop = true;
                        }
                    }
                    i++;
                }
                stop = false;
            }
            i = 1;
        }
        return res;
    }
}
