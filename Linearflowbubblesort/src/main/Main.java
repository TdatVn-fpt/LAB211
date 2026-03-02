package main;

import entity.Array;
import java.util.List;
import utils.Validator;

public class Main {
    public static void main(String[] args) {
        // Bước 1: Nhập số lượng phần tử
        int number = Validator.getInt("Enter number of array: ",
                "Number must be > 0", "Invalid input, please enter a number!", 1, Integer.MAX_VALUE);

        int[] array = null;
        try {
            // Bước 2: Tạo và sinh mảng ngẫu nhiên
            array = Array.ArrayUtils.createRandomArray(number);
            
            // Bước 3: Nhập giá trị cần tìm
            int key = Validator.getInt("Enter search value: ",
                    "Error range!", "Invalid input!", Integer.MIN_VALUE, Integer.MAX_VALUE);

            // Bước 4: Hiển thị mảng đã sinh
            Array.ArrayUtils.display(array);

            // Bước 5: Thực hiện tìm kiếm
            List<Integer> indexList = Array.ArrayUtils.linearSearch(array, key);

            // Bước 6: Thông báo kết quả
            if (indexList.isEmpty()) {
                System.out.println("Value " + key + " not found in the array.");
            } else {
                System.out.println("Found " + key + " at index: " + indexList);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}