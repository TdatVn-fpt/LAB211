
package controller;

import java.util.Scanner;

public class Validation {
  private static Scanner sc = new Scanner(System.in);
  
  private static double checkInt(String msg, int min, int max){
      System.out.println(msg);
      while (true) {          
          try {
              int result = Integer.parseInt(sc.nextLine().trim());
              if (result >= min && result <= max) {
                  return  result;
              } else{
                  System.out.println("Input the integer in rage(" + min + "->" + max +"):");
              }
          } catch (NumberFormatException e) {
              System.out.println("Input the number of interger.");
          }
      }
  }
    
}
