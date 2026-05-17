/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.CandidateType;
import model.Candidates;
import model.ExperienceCandidate;
import model.FresherCandidate;
import model.InternCandidate;
import model.RankOfGraduation;

/**
 *
 * @author dotha
 */
public class Manager {

    private ArrayList<Candidates> candidatesesList;

    public Manager() {
        this.candidatesesList = new ArrayList<>();
    }

    public int addExperience(int experienceYear, String professionalSkill,
            int candidateID, String firstName, String lastName, int birthDate,
            String address, int phone, String email) {
                ExperienceCandidate newExperience = new ExperienceCandidate(experienceYear, professionalSkill,
                candidateID, firstName, lastName, birthDate, address, phone, email, CandidateType.EXPERIENCE);
            candidatesesList.add(newExperience);
            return candidateID;
    }
    
    public int addFresher(int graduateTime, RankOfGraduation rankOfGraduation, String universityName, 
            int candidateID, String firstName, String lastName, int birthDate, 
            String address, int phone, String email) {
        FresherCandidate newFresher = new FresherCandidate(graduateTime, rankOfGraduation, universityName, 
                candidateID, firstName, lastName, birthDate, address, phone, email, CandidateType.FRESHER);
        candidatesesList.add(newFresher);
        return candidateID;
    }
    
    public int addIntern(String majors, int semester, String universityName, int candidateID, 
            String firstName, String lastName, int birthDate, String address,
            int phone, String email) {
        InternCandidate newIntern = new InternCandidate(majors, semester, universityName, candidateID, 
                firstName, lastName, birthDate, address, phone, email, CandidateType.INTERN);
        candidatesesList.add(newIntern);
        return candidateID;
    }
    
    public List<Candidates> getlist() {
        return candidatesesList;
    }
    
    public boolean checkList() {
        return candidatesesList.isEmpty();
    }
    
    public void search(String name, int candidateType) {
        for (Candidates candidates : candidatesesList) {
            if ((candidates.getFirstName().equalsIgnoreCase(name) || candidates.getLastName().equalsIgnoreCase(name))
                    && candidates.getCandidateType().getID() == candidateType) {
                System.out.println(candidates);
            }
        }
    }
    
    public void listAll() {
        System.out.println("==========EXPERIENCE CANDIDATE==========");
        for (Candidates candidates : candidatesesList) {
            if (candidates.getClass() == ExperienceCandidate.class) {
                System.out.println(candidates.getFirstName() + " " + candidates.getLastName());
            }
        }
        System.out.println("==========FRESHER CANDIDATE==========");
        for (Candidates candidates : candidatesesList) {
            if (candidates.getClass() == FresherCandidate.class) {
                System.out.println(candidates.getFirstName() + " " + candidates.getLastName());
            }
        }
        System.out.println("==========INTERN CANDIDATE==========");
        for (Candidates candidates : candidatesesList) {
            if (candidates.getClass() == InternCandidate.class) {
                System.out.println(candidates.getFirstName() + " " + candidates.getLastName());
            }
        }
        System.out.println();
    }
}
