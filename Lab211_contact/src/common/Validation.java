package common;

import java.util.Scanner;

public class Validation {
    private static final Scanner sc = new Scanner(System.in);
    
    // Regex cho các định dạng số điện thoại được yêu cầu
    private static final String VALID_PHONE = "^[0-9]{10}$"
            + "|^[0-9]{3}[-.\\s][0-9]{3}[-.\\s][0-9]{4}$"
            + "|^[0-9]{3}-[0-9]{3}-[0-9]{4}\\s?(x|ext)[0-9]{4}$"
            + "|^\\([0-9]{3}\\)-[0-9]{3}-[0-9]{4}$";

    public static int getInt(String msg, String err) {
        while (true) {
            try {
                System.out.print(msg);
                int num = Integer.parseInt(sc.nextLine().trim());
                if (num > 0) return num;
                System.out.println(err);
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }

    public static String getString(String msg, String err) {
        while (true) {
            System.out.print(msg);
            String str = sc.nextLine().trim();
            if (!str.isEmpty()) return str;
            System.out.println(err);
        }
    }

    public static String getPhone(String msg, String err) {
        while (true) {
            System.out.print(msg);
            String phone = sc.nextLine().trim();
            if (phone.matches(VALID_PHONE)) {
                return phone;
            }
            System.out.println("Please input Phone flow\n" +
                    "* 1234567890\n" +
                    "* 123-456-7890\n" +
                    "* 123-456-7890 x1234\n" +
                    "* 123-456-7890 ext1234\n" +
                    "* (123)-456-7890\n" +
                    "* 123.456.7890\n" +
                    "* 123 456 7890");
        }
    }
}