package controller;

import model.Candidate;
import java.util.ArrayList;

public class CandidateController {
    private ArrayList<Candidate> list = new ArrayList<>();

    public void addCandidate(Candidate c) {
        list.add(c);
    }

    public ArrayList<Candidate> getAll() {
        return list;
    }

    public ArrayList<Candidate> search(String name, int type) {
        ArrayList<Candidate> result = new ArrayList<>();

        for (Candidate c : list) {
            if (c.getCandidateType() == type &&
                (c.getFirstName().toLowerCase().contains(name.toLowerCase())
                    || c.getLastName().toLowerCase().contains(name.toLowerCase()))) {
                result.add(c);
            }
        }
        return result;
    }
    public Candidate getCandidateByID(String id){
        for (Candidate c : list) {
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }
    public void showAll() {
        System.out.println("\n===========EXPERIENCE CANDIDATE============");
        for (Candidate c : list) {
            if (c.getCandidateType() == 0) {
                System.out.println(c.getFullName());
            }
        }

        System.out.println("\n==========FRESHER CANDIDATE==============");
        for (Candidate c : list) {
            if (c.getCandidateType() == 1) {
                System.out.println(c.getFullName());
            }
        }

        System.out.println("\n===========INTERN CANDIDATE==============");
        for (Candidate c : list) {
            if (c.getCandidateType() == 2) {
                System.out.println(c.getFullName());
            }
        }
    }
}