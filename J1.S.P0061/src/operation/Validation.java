package operation;

import java.util.Scanner;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    public static double checkDouble(String msg, double min, double max) {
        System.out.println(msg);
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result >= min && result <= max) {
                    return result;
                } else {
                    System.err.print("Please input number in rangle. Enter again:");
                }
            } catch (NumberFormatException e) {
                System.out.print("Please input number of double:");
            }
        }
    }
}
