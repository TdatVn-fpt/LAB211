/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Manager;
import model.CandidateType;
import model.RankOfGraduation;
import util.Validate;

/**
 *
 * @author dotha
 */
public class Show {

    private Manager mng;
    private Validate vld;

    public Show(Manager mng, Validate vld) {
        this.mng = mng;
        this.vld = vld;
    }

    public void menu() {
        mng.addExperience(5, "Java Developer", 101, "Nguyen", "Hoang", 1990,
                "Ha Noi", 987654321, "hoang.nguyen@fpt.edu.vn");

        mng.addExperience(8, "Project Manager", 102, "Tran", "Lan", 1988,
                "Ho Chi Minh", 912345678, "tran.lan@gmail.com");

        mng.addExperience(3, "C# Backend", 103, "Pham", "Minh", 1992,
                "Da Nang", 934567890, "pham.minh@outlook.com");

        mng.addExperience(10, "Database Administrator", 104, "Le", "Tuan", 1985,
                "Hai Phong", 901234567, "le.tuan@fpt.edu.vn");

        mng.addExperience(6, "Front-end Developer", 105, "Do", "Anh", 1991,
                "Can Tho", 976543210, "do.anh@gmail.com");

        mng.addFresher(2023, RankOfGraduation.EXCELLENCE, "FPT University",
                201, "Le", "Mai", 2001, "Da Nang", 934567891, "le.mai@fpt.edu.vn");

        mng.addFresher(2022, RankOfGraduation.GOOD, "Bach Khoa University",
                202, "Do", "Quang", 2000, "Hue", 912345679, "do.quang@gmail.com");

        mng.addFresher(2023, RankOfGraduation.FAIR, "Hutech University",
                203, "Tran", "Bao", 1999, "Ho Chi Minh", 945678912, "tran.bao@hutech.edu.vn");

        mng.addFresher(2024, RankOfGraduation.EXCELLENCE, "PTIT",
                204, "Nguyen", "Anh", 2002, "Ha Noi", 987654322, "nguyen.anh@ptit.edu.vn");

        mng.addFresher(2021, RankOfGraduation.POOR, "Can Tho University",
                205, "Pham", "Huyen", 1998, "Can Tho", 965432109, "pham.huyen@ctu.edu.vn");

        mng.addIntern("Software Engineering", 6, "FPT University",
                301, "Pham", "Thanh", 2003, "Ha Noi", 977889999, "thanh.pham@fpt.edu.vn");

        mng.addIntern("Data Science", 5, "Can Tho University",
                302, "Ho", "Anh", 2004, "Can Tho", 903456789, "ho.anh@ctu.edu.vn");

        mng.addIntern("Information Security", 7, "Bach Khoa University",
                303, "Nguyen", "Quoc", 2002, "Ho Chi Minh", 981112223, "nguyen.quoc@hcmut.edu.vn");

        mng.addIntern("Multimedia Communication", 8, "RMIT Vietnam",
                304, "Le", "My", 2001, "Da Nang", 965554433, "le.my@rmit.edu.vn");

        mng.addIntern("Artificial Intelligence", 4, "PTIT",
                305, "Tran", "Duy", 2005, "Ha Noi", 934445556, "tran.duy@ptit.edu.vn");

        while (true) {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            int menu = vld.checkInt("Enter menu: ", "Invalid input!", 1, 5);
            switch (menu) {
                case 1:
                    addExperienceUI();
                    break;
                case 2:
                    addFresherUI();
                    break;
                case 3:
                    addInternUI();
                    break;
                case 4:
                    showUI();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    public void addExperienceUI() {
        String str;
        do {
            int candidateID = vld.checkInt("Enter Candidate ID: ", "Invalid input!", Integer.MIN_VALUE, Integer.MAX_VALUE);
            String firstName = vld.checkString("Enter First Name: ", "Invalid input!", ".+");
            String lastName = vld.checkString("Enter Last Name: ", "Invalid Input!", ".+");
            int birthDate = vld.checkInt("Enter Birth Date: ", "Invalid input!", 1900, 2025);
            String address = vld.checkString("Enter Address: ", "Invalid Input!", ".+");
            int phone = vld.checkInt("Enter Phone: ", "Invalid IOnput!", Integer.MIN_VALUE, Integer.MAX_VALUE);
            String email = vld.checkString("Enter Email: ", "Invalid Input!", "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
            int experienceYear = vld.checkInt("Enter Experience Year: ", "Invalid Input!", 0, 100);
            String professionalSkill = vld.checkString("Enter Professional Skill: ", "Invalid Input!", ".+");
            System.out.println("Add success, ID: " + mng.addExperience(experienceYear, professionalSkill, candidateID, firstName, lastName, birthDate, address, phone, email));
            str = vld.checkString("Do You want continue? (Y/N): ", "Invalid Input!", "[YNyn]");
        } while (str.equalsIgnoreCase("y"));
    }

    public void addFresherUI() {
        String str;
        do {
            int candidateID = vld.checkInt("Enter Candidate ID: ", "Invalid input!", Integer.MIN_VALUE, Integer.MAX_VALUE);
            String firstName = vld.checkString("Enter First Name: ", "Invalid input!", ".+");
            String lastName = vld.checkString("Enter Last Name: ", "Invalid Input!", ".+");
            int birthDate = vld.checkInt("Enter Birth Date: ", "Invalid input!", 1900, 2025);
            String address = vld.checkString("Enter Address: ", "Invalid Input!", ".+");
            int phone = vld.checkInt("Enter Phone: ", "Invalid IOnput!", Integer.MIN_VALUE, Integer.MAX_VALUE);
            String email = vld.checkString("Enter Email: ", "Invalid Input!", "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
            int graduateTime = vld.checkInt("Enter graduate Time : ", "Invalid Input!", 0, 100);
            RankOfGraduation rankOfGraduation = vld.checkRank("Enter Rank: ", "Invalid Input!");
            System.out.println("Add success, ID: " + mng.addFresher(graduateTime, rankOfGraduation, firstName, candidateID, firstName, lastName, birthDate, address, phone, email));
            str = vld.checkString("Do You want continue? (Y/N): ", "Invalid Input!", "[YNyn]");
        } while (str.equalsIgnoreCase("y"));
    }

    public void addInternUI() {
        String str;
        do {
            int candidateID = vld.checkInt("Enter Candidate ID: ", "Invalid input!", Integer.MIN_VALUE, Integer.MAX_VALUE);
            String firstName = vld.checkString("Enter First Name: ", "Invalid input!", ".+");
            String lastName = vld.checkString("Enter Last Name: ", "Invalid Input!", ".+");
            int birthDate = vld.checkInt("Enter Birth Date: ", "Invalid input!", 1900, 2025);
            String address = vld.checkString("Enter Address: ", "Invalid Input!", ".+");
            int phone = vld.checkInt("Enter Phone: ", "Invalid IOnput!", Integer.MIN_VALUE, Integer.MAX_VALUE);
            String email = vld.checkString("Enter Email: ", "Invalid Input!", "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
            String majors = vld.checkString("Enter Major: ", "Invalid Input!", ".+");
            int semester = vld.checkInt("Enter Semester: ", "Invalid Input!", 1, 9);
            String universityName = vld.checkString("Enter University Name: ", "Invalid Input!", ".+");
            System.out.println("Add succes, ID: " + mng.addIntern(majors, semester, universityName, candidateID, firstName, lastName, birthDate, address, phone, email));
            str = vld.checkString("Do You want continue? (Y/N): ", "Invalid Input!", "[YNyn]");
        } while (str.equalsIgnoreCase("y"));
    }

    public void showUI() {
        if (mng.checkList()) {
            System.out.println("Empty!");
            return;
        }
        mng.listAll();
        String name = vld.checkString("Input Candidate Name (Firts Name or Last Name): ", "Invalide Input!", ".+");
        CandidateType candidateType = vld.checkCandidateType("Input type of Candidate: ", "Invalid Input!");
        mng.search(name, candidateType.getID());
        System.out.println();
    }

}
