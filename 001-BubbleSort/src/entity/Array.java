
package entity;

import java.util.Random;
public class Array {
    
   
        
        // Tạo mảng và sinh ra giá trị ngẫu nhiên
        public static int[] createRandomArray(int number){
            int [] array = new int[number];
            Random random = new Random();
            for (int i = 0; i < number; i++) {
                array[i] = random.nextInt(number);
            }
            return array;
        }
        
        
        // Bước 4 hiển thị mảng
        public static void display(int[] array, String message) {
            System.out.print(message + ": [");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    
       
        // thuật toán bubble sort
        public static void bubbleSort(int[] array) {
            int n = array.length;
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - 1 ; j++) {
                    if (array[j] > array[j + 1]) {
                        // tráo đổi nếu chúng sai thứ tự
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        swapped = true;
                    }
                }
                if(!swapped) break;
            }
        }
    
}
