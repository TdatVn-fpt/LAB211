package utils;

import java.util.Scanner;

public class Validator {
    public static Scanner SCANNER = new Scanner(System.in);
   
    private Validator(){    
    }
    
    public static int getInt(String messageInfor
            , String messageErrorOutOfRange,
            String messageErrorNumber, int min, int max){
        do {            
            try {
                System.out.println(messageInfor);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }else {
                    System.err.println(messageErrorOutOfRange);
                }
            } catch (NumberFormatException e) {
                System.err.println(messageErrorNumber);
            } 
        } while (true);
    }
}
