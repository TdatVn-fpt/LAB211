/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;
import model.Course;

/**
 *
 * @author dotha
 */
public class Validate {

    private Scanner sc = new Scanner(System.in);

    public String checkString(String msg, String regex) {
        while (true) {
            System.out.print(msg);
            String str = sc.nextLine();
            if (str.matches(regex)) {
                return str;
            }
        }
    }

    public int checkInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int a = Integer.parseInt(sc.nextLine());
                if (a >= min && a <= max) {
                    return a;
                }
                System.out.println("Please input in range " + "(" + min + " - " + max + ")");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, Enter a Integer!");
            }
        }
    }

    public boolean checkYesNo(String msg, String regex) {
        while (true) {
            String str = checkString("Enter ", regex);
        }
    }

    public Course checkCourse(String msg) {
        while (true) {
            String str = checkString(msg, ".+");
            if (Course.findCourse(str) != null) {
                return Course.findCourse(str);
            } else {
                System.out.println("Invalid course!");
            }
        }
    }
    
    public Course checkCourseAndNull(String msg) {
        while (true) {
            String str = checkString(msg, ".*");
            if (str.isEmpty()) {
                return null;
            }
            if (Course.findCourse(str) != null) {
                return Course.findCourse(str);
            } else {
                System.out.println("Invalid course!");
            }
        }
    }
    
}
