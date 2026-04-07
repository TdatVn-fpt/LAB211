/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author thuha
 */
public class Validator {

    private Validator() {
    }
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getInt(String messageInfo, String messErrorOutOfRange,
            String messageErrorNumber, int min, int max) {
        do {
            try {
                System.out.print(messageInfo);
                //tranh loi troi lenh convet "1234"-->1234
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println(messErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);

    }

    public static double getDouble(String messageInfo, String messErrorOutOfRange,
            String messageErrorNumber, double min, double max) {
        do {
            try {
                System.out.print(messageInfo);
                double number = Double.parseDouble(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println(messErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        } while (true);
    }

    public static String getString(String messageInfo, String messageError,
            final String REGEX) {
        do {
            try {
                System.out.print(messageInfo);
                String str = SCANNER.nextLine().toUpperCase();
                if (str.matches(REGEX)) {
                    return str;
                } else {
                    System.out.println(messageError);
                }
            } catch (Exception e) {
                System.out.println(messageError);
            }
        } while (true);

    }
}
