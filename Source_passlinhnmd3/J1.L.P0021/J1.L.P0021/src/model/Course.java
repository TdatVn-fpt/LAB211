/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dotha
 */
public enum Course {

    JAVA("Java"),
    DOTNET(".NET"),
    C_AND_C_PLUS("C/C++");

    private String courseName;

    private Course(String courseName) {
        this.courseName = courseName;
    }

    public static Course findCourse(String courseName) {
        for (Course course : values()) {
            if (course.getCourseName().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null;
    }

    public String getCourseName() {
        return courseName;
    }
    


}
