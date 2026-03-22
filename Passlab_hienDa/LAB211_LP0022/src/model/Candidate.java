package model;

public abstract class Candidate {
    protected String id, firstName, lastName, birthDate, address, phone, email;
    protected int candidateType;

    public Candidate(String id, String firstName, String lastName, String birthDate,
                     String address, String phone, String email, int candidateType) {
        setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        setCandidateType(candidateType);
    }

    public String getId() {
        return id;
    }

    /** Id là chuỗi biểu diễn số nguyên, không được nhỏ hơn 0. */
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Id must not be empty.");
        }
        String t = id.trim();
        try {
            int n = Integer.parseInt(t);
            if (n < 0) {
                throw new IllegalArgumentException("Id must not be less than 0.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Id must be a non-negative integer.");
        }
        this.id = t;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getCandidateType() {
        return candidateType;
    }

    /** Chỉ 0 (Experience), 1 (Fresher), 2 (Intern). */
    public void setCandidateType(int candidateType) {
        if (candidateType < 0 || candidateType > 2) {
            throw new IllegalArgumentException("Candidate type must be 0, 1, or 2.");
        }
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        return getFullName() + " | " + birthDate + " | " + address + " | "
                + phone + " | " + email + " | " + candidateType;
    }
}
