package model;

public class Intern extends Candidate {
    private String major, semester, university;

    public Intern(String id, String firstName, String lastName, String birthDate,
                  String address, String phone, String email,
                  String major, String semester, String university) {
        super(id, firstName, lastName, birthDate, address, phone, email, 2);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
