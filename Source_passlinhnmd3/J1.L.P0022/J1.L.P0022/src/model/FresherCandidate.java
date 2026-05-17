/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dotha
 */
public class FresherCandidate extends Candidates {

    private int graduateTime;
    private RankOfGraduation rankOfGraduation;
    private String universityName;

    public FresherCandidate() {
    }


    public FresherCandidate(int graduateTime, RankOfGraduation rankOfGraduation, String universityName, int candidateID, String firstName, String lastName, int birthDate, String address, int phone, String email, CandidateType candidateType) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.graduateTime = graduateTime;
        this.rankOfGraduation = rankOfGraduation;
        this.universityName = universityName;
    }

    public int getGraduateTime() {
        return graduateTime;
    }

    public void setGraduateTime(int graduateTime) {
        this.graduateTime = graduateTime;
    }

    public RankOfGraduation getRankOfGraduation() {
        return rankOfGraduation;
    }

    public void setRankOfGraduation(RankOfGraduation rankOfGraduation) {
        this.rankOfGraduation = rankOfGraduation;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %s | %s | %s", graduateTime, 
                rankOfGraduation.getRankOfGraduationString(), universityName);
    }

}
