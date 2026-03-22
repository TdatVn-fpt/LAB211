package model;

public class Fresher extends Candidate {
    private String graduationDate, graduationRank, education;

    public Fresher(String id, String firstName, String lastName, String birthDate,
                   String address, String phone, String email,
                   String graduationDate, String graduationRank, String education) {
        super(id, firstName, lastName, birthDate, address, phone, email, 1);
        this.graduationDate = graduationDate;
        setGraduationRank(graduationRank);
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        if (graduationRank == null || graduationRank.trim().isEmpty()) {
            throw new IllegalArgumentException("Graduation rank must not be empty.");
        }
        String t = graduationRank.trim();
        if (!t.matches("(?i)(Excellence|Good|Fair|Poor)")) {
            throw new IllegalArgumentException(
                    "Graduation rank must be Excellence, Good, Fair, or Poor.");
        }
        switch (t.toLowerCase()) {
            case "excellence":
                this.graduationRank = "Excellence";
                break;
            case "good":
                this.graduationRank = "Good";
                break;
            case "fair":
                this.graduationRank = "Fair";
                break;
            case "poor":
                this.graduationRank = "Poor";
                break;
            default:
                throw new IllegalArgumentException(
                        "Graduation rank must be Excellence, Good, Fair, or Poor.");
        }
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
