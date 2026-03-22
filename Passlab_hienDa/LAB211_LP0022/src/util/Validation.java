package util;

import java.time.Year;
import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    public static String inputString(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }

    public static String inputBirthDate() {
        while (true) {
            String year = inputString("Birth year: ");
            if (year.matches("\\d{4}")) {
                int y = Integer.parseInt(year);
                if (y >= 1900 && y <= Year.now().getValue()) return year;
            }
            System.out.println("Invalid!");
        }
    }

    public static String inputPhone() {
        while (true) {
            String phone = inputString("Phone: ");
            if (phone.matches("\\d{10,}")) return phone;
            System.out.println("Invalid!");
        }
    }

    public static String inputEmail() {
        while (true) {
            String email = inputString("Email: ");
            if (email.matches("^[\\w]+@[\\w]+\\.[\\w]+$")) return email;
            System.out.println("Invalid!");
        }
    }

    public static int inputExp() {
        while (true) {
            try {
                int exp = Integer.parseInt(inputString("Experience: "));
                if (exp >= 0 && exp <= 100) return exp;
            } catch (Exception e) {}
            System.out.println("Invalid!");
        }
    }

    public static String inputRank() {
        while (true) {
            String rank = inputString("Rank: ");
            if (rank.matches("Excellence|Good|Fair|Poor")) return rank;
            System.out.println("Invalid!");
        }
    }
}