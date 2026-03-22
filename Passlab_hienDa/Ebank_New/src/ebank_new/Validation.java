
package ebank_new;

import java.util.Scanner;

public class Validation {

    public static int getInterger(String msg, int min, int max) {

        int data;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {

                System.out.print(msg);

                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.err.println("Must be a number");
                } else {

                    data = Integer.parseInt(input);

                    if (data < min || data > max) {
                        throw new IllegalArgumentException("Please choice: "
                                + min + " to " + max);
                    }

                    return data;
                }

            } catch (NumberFormatException e) {
                System.out.println("Must be a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getString(String msg, String msgerror, String regex) {

        String input;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print(msg);

            input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("Not empty!");
            } else if (input.matches(regex)) {
                return input;
            } else {
                System.out.println(msgerror);
            }
        }
    }

    public static final String REGEX_STRING = "[0-9]{10}";
    public static final String REGEX_PASSWORD = "^(?=.*\\d)(?=.*[a-zA-Z]).{8,31}$";
//    public static final String REGEX_CAPTCHA = "[a-zA-Z0-9]{2,}";
//    public static final String REGEX_CAPTCHA ="^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{3,}$";
    public static final String REGEX_CAPTCHA = ".+";    // chỉ cần sửa regex là nó sẽ sinh ra ngẫu nhiên khi nhập sai captra
}  // CÓ NGHĨA LÀ CHUỖI PHẢI CÓ 1 KÍ TỰ ĐẶC BIỆT VÀ KHÔNH ĐƯỢC RỖNG
