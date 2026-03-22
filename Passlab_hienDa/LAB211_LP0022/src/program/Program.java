package program;

import controller.CandidateController;
import model.*;
import util.Validation;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    static CandidateController controller = new CandidateController();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nCANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Intern");
            System.out.println("4. Searching");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    createExperience();
                    break;
                case 2:
                    createFresher();
                    break;
                case 3:
                    createIntern();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    return;
            }
        }
    }

    // ================= CREATE =================

    static void createExperience() {
        do {
            String id;
            while (true) {
                id = Validation.inputString("Enter id: ");
                if (controller.getCandidateByID(id) == null) {
                    break;
                }
                System.out.println("ID is exist please enter again....");
            }
            String firstName = Validation.inputString("First name: ");
            String lastName = Validation.inputString("Last name: ");
            String birthDate = Validation.inputBirthDate();
            String address = Validation.inputString("Address: ");
            String phone = Validation.inputPhone();
            String email = Validation.inputEmail();
            int expInYear = Validation.inputExp();
            String proSkill = Validation.inputString("Professional skill: ");

            Candidate c = new Experience(
                    id, firstName, lastName, birthDate, address, phone, email,
                    expInYear, proSkill);
            controller.addCandidate(c);
        } while (askContinue());

        controller.showAll();
    }

    static void createFresher() {
        do {
            Candidate c = new Fresher(
                    Validation.inputString("ID: "),
                    Validation.inputString("First name: "),
                    Validation.inputString("Last name: "),
                    Validation.inputBirthDate(),
                    Validation.inputString("Address: "),
                    Validation.inputPhone(),
                    Validation.inputEmail(),
                    Validation.inputString("Graduation date: "),
                    Validation.inputRank(),
                    Validation.inputString("University: ")
            );

            controller.addCandidate(c);

        } while (askContinue());

        controller.showAll();
    }

    static void createIntern() {
        do {
            Candidate c = new Intern(
                    Validation.inputString("ID: "),
                    Validation.inputString("First name: "),
                    Validation.inputString("Last name: "),
                    Validation.inputBirthDate(),
                    Validation.inputString("Address: "),
                    Validation.inputPhone(),
                    Validation.inputEmail(),
                    Validation.inputString("Major: "),
                    Validation.inputString("Semester: "),
                    Validation.inputString("University: ")
            );

            controller.addCandidate(c);

        } while (askContinue());

        controller.showAll();
    }

    // ================= SEARCH =================

    static void search() {
        controller.showAll();

        String name = Validation.inputString("Input name: ");
        int type = Integer.parseInt(Validation.inputString("Type (0-2): "));

        ArrayList<Candidate> result = controller.search(name, type);

        System.out.println("\nThe candidates found:");
        for (Candidate c : result) {
            System.out.println(c);
        }
    }

    // ================= UTIL =================

    static boolean askContinue() {
        System.out.print("Do you want to continue (Y/N)? ");
        return sc.nextLine().equalsIgnoreCase("Y");
    }
}