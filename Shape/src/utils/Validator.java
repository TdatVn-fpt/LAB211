package utils;

import java.util.Scanner;

public class Validator {
    private static Scanner sc = new Scanner(System.in);

    public static double getDouble(String msg, double min) {
        double n;
        while (true) {
            try {
                System.out.print(msg);
                n = Double.parseDouble(sc.nextLine());
                if (n > min) return n;
            } catch (Exception e) {}
            System.out.println("Invalid input!");
        }
    }

    public static int getInt(String msg, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) return n;
            } catch (Exception e) {}
            System.out.println("Invalid choice!");
        }
    }
}
