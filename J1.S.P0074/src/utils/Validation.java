/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matran.util;

import java.util.Scanner;

/**
 *
 * @author Hieu
 */
public class Validation {
    
    Scanner sc = new Scanner(System.in);

    public String getString(String str) {
        while (true) {
            String ret = sc.nextLine();
            if (ret.isEmpty()) {
                System.out.print(str + " must be not null,Try Again!!! : ");
            } else {
                return ret;
            }
        }
    }

    public int getInt(String str) {
        System.out.print("Enter " + str + " : ");

        while (true) {
            try {
                return Integer.parseInt(getString(str));

            } catch (Exception e) {
                System.out.print(str + "must be Number,Try Again!!! : ");
            }
        }

    }

    public int getPositiveInt(String str) {
        while (true) {
            int temp = getInt(str);
            if (temp > 0) {
                return temp;
            } else {
                System.out.println(str + " must positive number !!! ");
            }
        }

    }
    public double getDouble(String str){
         System.out.print("Enter " + str + " : ");

        while (true) {
            try {
                return Double.parseDouble(getString(str));

            } catch (Exception e) {
                System.out.print(str + "must be Number,Try Again!!! : ");
            }
        }
    }
}
