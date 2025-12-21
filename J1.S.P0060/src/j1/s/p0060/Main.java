package j1.s.p0060;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    //Kiểm tra nhập số nguyên dương tránh nhập số âm hoặc chữ
    private static int checkInput() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
//                if (result < 0) {
//                    System.out.println("Please input number greater than 0:");
//                    continue;
//                }
//                return result; // phải có trả về kết quả sau khi kiểm tra không hợp lệ
//viết throw new Exception(), bạn đang ra lệnh cho chương trình: "Đây là một lỗi, đừng chạy tiếp các dòng bên dưới nữa, hãy nhảy ngay lập tức vào khối catch
                if (result < 0) throw new Exception();
                return result;
            } catch (Exception e) {
                System.out.println("Re-input:");
            }

        }

    }

    public static int calcTotal(int[] bills) {
        int total = 0;
        for (int bill : bills) {
            total += bill;
        }
        return total;  // trả về tổng hóa đơn
    }

    public static void main(String[] args) {
        System.out.println("=====Shopping program=====");
        // 1. Nhập số lượng hóa đơn 
        System.out.print("Input number of bills: ");
        int n = checkInput();
        int[] bills = new int[n];

        //2 nhập giá trị cho từng hóa đơn
        for (int i = 0; i < n; i++) {
            System.out.print("Input value of bill " + (i + 1) + ": ");
            bills[i] = checkInput();
        }

        // 3 nhập tiền trong ví
        System.out.print("Input value of wallet:");
        int walletAmount = checkInput();

        //4 xử lý logic
        int total = calcTotal(bills);
        Wallet myWallet = new Wallet(walletAmount);
        Person customer = new Person(myWallet);

        //5 hiển thị kết quả
        System.out.println("This is total of bill:" + total);
        if (customer.getWallet().payMoney(total)) {  // lớp main băng qua lớp person gọi wallet
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can't buy it.");
        }

    }

}
