package model;

public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience(String id, String firstName, String lastName, String birthDate,
                      String address, String phone, String email,
                      int expInYear, String proSkill) {
        super(id, firstName, lastName, birthDate, address, phone, email, 0);
        setExpInYear(expInYear);
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        if (expInYear < 0 || expInYear > 100 ) {
            throw new IllegalArgumentException("Experience year must be between 0 and 100.");
        }
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
