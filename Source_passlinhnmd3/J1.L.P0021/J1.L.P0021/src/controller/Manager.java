/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Course;
import model.Report;
import model.Student;

/**
 *
 * @author dotha
 */
public class Manager {

    private ArrayList<Student> listStudent;

    public Manager() {
        this.listStudent = new ArrayList<>();
    }

    public int addStudent(String studentName, String semester, Course courseName) {
        int id;
        if (listStudent.isEmpty()) {
            id = 1;
        } else {
            id = Integer.parseInt(listStudent.get(listStudent.size() - 1).getId()) + 1;
        }
        Student student = new Student(String.valueOf(id), studentName, semester, courseName);
        listStudent.add(student);
        return id;
    }

    public List<Student> findStudentByName(String studentName) {
        List<Student> tempList = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getStudentName().contains(studentName)) {
                tempList.add(student);
            }
        }
        return tempList;
    }

    public List<Student> sortAfterFound(String studentName) {
        List<Student> sorting = findStudentByName(studentName);
        Collections.sort(sorting, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareToIgnoreCase(o2.getStudentName());
            }
        });
        return sorting;
    }

    public void update(int index, String studentName, String semester, Course courseName) {
        listStudent.get(index).setCourseName(courseName);
        listStudent.get(index).setSemester(semester);
        listStudent.get(index).setStudentName(studentName);
    }

    public void delete(int index) {
        listStudent.remove(index);
    }

    public ArrayList<Report> report() {
        ArrayList<Report> reportList = new ArrayList<>();
        for (Student student : listStudent) {
            int index = checkReport(reportList, student.getStudentName(), student.getCourseName());
            if (index != -1) {
                reportList.get(index).setTotalOfCourse(reportList.get(index).getTotalOfCourse() + 1);
            } else {
                reportList.add(new Report(student.getStudentName(), student.getCourseName(), 1));
            }
        }
        return reportList;
    }

    public int checkReport(ArrayList<Report> report, String name, Course course) {
        int index = 0;
        for (Report report1 : report) {
            if (report1.getStudentName().equalsIgnoreCase(name) && report1.getCourseName().equalsIgnoreCase(course.getCourseName())) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int findById(String id) {
        int i = 0;
        for (Student student : listStudent) {
            if (student.getId().equals(id)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean checkList() {
        return listStudent.isEmpty();
    }

    public String returnStringIfEmpty(String str, int i, int index) {
        if (!checkEmpty(str)) {
            return str;
        }
        switch (i) {
            case 1:
                return listStudent.get(index).getStudentName();
            case 2:
                return listStudent.get(index).getSemester();
            default:
                return str;
        }
    }
    
    public Course returnCourseIfEmpty(Course course, int index) {
        if (course != null) {
            return course;
        }
        return listStudent.get(index).getCourseName();
    }

    public boolean checkEmpty(String str) {
        return str.isEmpty();
    }
}
