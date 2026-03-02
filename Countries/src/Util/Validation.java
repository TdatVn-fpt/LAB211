package Util;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {
    private Scanner sc;

    public Validation() {
        sc = new Scanner(System.in);
    }
    
    public String checkInputString(String msg) {
        //loop until user input correct
        while (true) {
            System.out.println(msg);
            String result = sc.nextLine();
            if (result.trim().isEmpty() || result.length() == 0) {
                System.out.println("Please not empty.... ");
            } else {
                return result;
            }
        }
    }
    public int checkInputInt(String msg,int min , int max){
        while (true) {
            String nhap = checkInputString(msg);
            try {
                int res = Integer.parseInt(nhap);
                if(min <= res && res <= max){
                    return res;
                }
                System.out.println("----Please enter from " + min + " to " + max);
            } catch (Exception e) {
                System.out.println("----Please not error input....");
            }
        }
    }
    public double checkTotalArea(String msg, double min){
        while (true) {  
            String nhap = checkInputString(msg);
            try {
                double res = Double.parseDouble(nhap);
                if(res > min){
                    return res;
                }
                System.out.println("----Total area must be greater than " + min);
            } catch (Exception e) {
                System.out.println("----Please enter only number....");
            }
        }
    }
}
