/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dotha
 */
public enum CandidateType {
    
    EXPERIENCE(0, "Experience"),
    FRESHER(1, "Fresher Candidate"),
    INTERN(2, "Intern Candidate");
    
    private int id;
    private String type;

    private CandidateType(int id, String type) {
        this.id = id;
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    public int getID() {
        return id;
    }
    
    public static CandidateType getCandidateTypeByID(int id) {
        for (CandidateType candidateType : values()) {
            if (candidateType.getID() == id) {
                return candidateType;
            }
        }
        return null;
    }
}
