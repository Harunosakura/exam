/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.unicodesprint;

/**
 *
 * @author Nesrin
 */
public class ExceedingSpeedLimit {
       // Complete the solve function below.
    static void solve(int s) {
        
        if (s > 110)
            System.out.println(((s-90)*500) +" License removed");
        else if(s >=91 && s<=110)
            System.out.println(((s-90)*300) +" Warning");
        else
            System.out.println("0 No punishment");
    }

    public static void main(String[] args)  {
        solve(90);
    }
}
