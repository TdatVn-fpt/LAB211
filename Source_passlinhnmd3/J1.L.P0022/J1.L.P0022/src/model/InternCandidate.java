/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dotha
 */
public class InternCandidate extends Candidates {

    private String majors;
    private int semester;
    private String universityName;

    public InternCandidate() {
    }

    public InternCandidate(String majors, int semester, String universityName, int candidateID, String firstName, String lastName, int birthDate, String address, int phone, String email, CandidateType candidateType) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %s | %s | %s", majors, semester, universityName);
    }

}
