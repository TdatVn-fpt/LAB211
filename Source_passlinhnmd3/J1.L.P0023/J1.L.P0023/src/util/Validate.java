/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author dotha
 */
public class Validate {
    
    private Scanner sc = new Scanner(System.in);
    
    public String checkString(String msg, String err, String regex) {
        while (true) {
            System.out.print(msg);
            String str = sc.nextLine();
            if (str.matches(regex)) {
                return str;
            }
            System.out.println(err);
        }
    }
    
    public int checkInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                int i = Integer.parseInt(checkString(msg, err, "[0-9]+"));
                if (i <= max && i >= min) {
                    return i;
                }
                System.out.println(err);
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }
    
    public double checkDouble(String msg, String err, double min, double max) {
        while (true) {
            try {
                double b = Double.parseDouble(checkString(msg, err, "^[0-9]+\\.[0-9]+$"));
                if (b <= max && b >= min) {
                    return b;
                }
                System.out.println(err);
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }
    
}
