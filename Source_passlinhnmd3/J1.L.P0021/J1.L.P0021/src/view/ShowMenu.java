/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Manager;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.Report;
import model.Student;
import util.Validate;

/**
 *
 * @author dotha
 */
public class ShowMenu {

    private Validate vld;
    private Manager mng;

    public ShowMenu() {
    }

    public ShowMenu(Validate vld, Manager msg) {
        this.vld = vld;
        this.mng = msg;
    }

    public void menuMain() {
        while (true) {
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            int menu = vld.checkInt("Enter: ", 1, 5);
            switch (menu) {
                case 1:
                    addStudentUI();
                    break;
                case 2:
                    findAndSortUI();
                    break;
                case 3:
                    updateORDeleteUI();
                    break;
                case 4:
                    reportUi();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    public void addStudentUI() {
        if (mng.checkList()) {
            int piv = 0;
            while (piv < 10) {
                String studentName = vld.checkString("Enter student Name: ", ".+");
                String semester = vld.checkString("Enter semester: ", ".+");
                Course courseName = vld.checkCourse("Enter Course Name: ");
                System.out.println("Add success, ID: " + mng.addStudent(studentName, semester, courseName));
                piv++;
            }
        } else {
            String studentName = vld.checkString("Enter student Name: ", ".+");
            String semester = vld.checkString("Enter semester: ", ".+");
            Course courseName = vld.checkCourse("Enter Course Name: ");
            System.out.println("Add success, ID: " + mng.addStudent(studentName, semester, courseName));
        }
    }

    public void findAndSortUI() {
        if (mng.checkList()) {
            System.out.println("List is Empty!");
            return;
        }
        String studentName = vld.checkString("Enter Name: ", ".+");
        List<Student> listStudent = mng.findStudentByName(studentName);
        if (listStudent.isEmpty()) {
            System.out.println("Name not found!");
            return;
        }
        System.out.printf("\"%-5s|%-10s|%-10s\n", "ID", "Name", "Semester", "Course");
        for (Student student : mng.sortAfterFound(studentName)) {
            System.out.println(student);
        }
        System.out.println();
    }

    public void updateUi(int index) {
        String studentName = mng.returnStringIfEmpty(vld.checkString("Enter Name: ", ".*"), 1, index);
        String semester = mng.returnStringIfEmpty(vld.checkString("Enter Semester: ", ".*"), 2, index);
        Course courseName = vld.checkCourseAndNull("Enter Course Name: ");
        courseName = mng.returnCourseIfEmpty(courseName, index);
        mng.update(index, studentName, semester, courseName);
        System.out.println("Update sucess!");
    }

    public void deleteUI(int index) {
        mng.delete(index);
        System.out.println("Delete success!");
    }

    public void updateORDeleteUI() {
        if (mng.checkList()) {
            System.out.println("List is Empty!");
            return;
        }
        int id = vld.checkInt("Enter id: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int x = mng.findById(String.valueOf(id));
        if (x != 1) {
            String choose = vld.checkString("Do you want to update (U) or delete (D) student: ", "[uUdD]");
            if (choose.equalsIgnoreCase("u")) {
                updateUi(x);
            } else {
                deleteUI(x);
            }
        }
    }

    public void reportUi() {
        if (mng.checkList()) {
            System.out.println("List is Empty!");
            return;
        }
        ArrayList<Report> reports = mng.report();
        System.out.printf("%-15s|%-10s|%-10s\n", "Name", "Course", "Total");
        for (Report report : reports) {
            System.out.println(report);
        }
        System.out.println();
    }
}
