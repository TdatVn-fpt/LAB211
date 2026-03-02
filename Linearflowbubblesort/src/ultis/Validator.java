package utils;

import java.util.Scanner;

public class Validator {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Validator() {} // Ngăn khởi tạo đối tượng vì đây là lớp tiện ích

    /**
     * Lấy số nguyên nhập từ bàn phím với kiểm tra khoảng và định dạng.
     */
    public static int getInt(String messageInfo, String messageErrorOutOfRange,
            String messageErrorNumber, int min, int max) {
        while (true) {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorNumber);
            }
        }
    }
}