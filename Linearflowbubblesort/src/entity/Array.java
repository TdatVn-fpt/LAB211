package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Array {
    public static class ArrayUtils {

        /**
         * Tạo mảng với các số ngẫu nhiên trong khoảng số lượng phần tử.
         */
        public static int[] createRandomArray(int number) throws Exception {
            if (number <= 0) {
                throw new Exception("Number of array must be > 0");
            }
            int[] array = new int[number];
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(number);
            }
            return array;
        }

        /**
         * Hiển thị mảng theo định dạng chuẩn.
         */
        public static void display(int[] array) {
            System.out.println("The array: " + Arrays.toString(array));
        }

        /**
         * Tìm kiếm tất cả các vị trí xuất hiện của giá trị key.
         */
        public static List<Integer> linearSearch(int[] array, int key) {
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                if (array[i] == key) {
                    indices.add(i);
                }
            }
            return indices;
        }
    }
}