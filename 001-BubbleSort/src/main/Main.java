package main;

import entity.Array;
import utils.Validator;

public class Main {
    public static void main(String[] args) {
        // 1. Người dùng nhập vào số lượng phần tử 
        int number = Validator.getInt("Enter number of array:", 
                "Number must be > 0", "Invalid input!", 1, Integer.MAX_VALUE);

        // 2 & 3. Tạo mảng và sinh số ngẫu nhiên [cite: 8, 15]
        int[] array = Array.createRandomArray(number);

        // 4. Hiển thị mảng chưa sắp xếp [cite: 9, 16]
        Array.display(array, "Unsorted array");

        // 5. Thực hiện sắp xếp nổi bọt (Bubble Sort) [cite: 3, 19]
        Array.bubbleSort(array);

        // 6. Hiển thị lại mảng đã sắp xếp [cite: 9, 16]
        Array.display(array, "Sorted array");
    }
}