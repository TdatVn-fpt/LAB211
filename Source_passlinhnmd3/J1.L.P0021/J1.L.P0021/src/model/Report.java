
package model;

/**
 *
 * @author dotha
 */
public class Report {

    private String studentName;
    private Course courseName;
    private int totalOfCourse;

    public Report() {
    }

    public Report(String studentName, Course courseName, int totalOfCourse) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalOfCourse = totalOfCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName.getCourseName();
    }

    public void setCourseName(Course courseName) {
        this.courseName = courseName;
    }

    public int getTotalOfCourse() {
        return totalOfCourse;
    }

    public void setTotalOfCourse(int totalOfCourse) {
        this.totalOfCourse = totalOfCourse;
    }

    @Override
    public String toString() {
        return String.format("%-15s|%-10s|%-10s\n", studentName, courseName.getCourseName(), totalOfCourse);
    }

}
