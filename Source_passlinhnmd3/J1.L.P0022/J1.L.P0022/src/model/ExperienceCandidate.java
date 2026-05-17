/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dotha
 */
public class ExperienceCandidate extends Candidates {

    private int experienceYear;
    private String professionalSkill;

    public ExperienceCandidate() {
    }

    public ExperienceCandidate(int experienceYear, String professionalSkill, int candidateID, String firstName, String lastName, int birthDate, String address, int phone, String email, CandidateType candidateType) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.experienceYear = experienceYear;
        this.professionalSkill = professionalSkill;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %s | %s", experienceYear, professionalSkill);
    }

}
