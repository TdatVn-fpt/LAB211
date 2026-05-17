/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;
import model.CandidateType;
import model.RankOfGraduation;

/**
 *
 * @author dotha
 */
public class Validate {

    private Scanner sc = new Scanner(System.in);

    public int checkInt(String msg, String err, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int str = Integer.parseInt(sc.nextLine());
                if (str >= min && str <= max) {
                    return str;
                } else {
                    System.out.println("Range " + min + " => " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }

    public String checkString(String msg, String err, String regex) {
        while (true) {
            System.out.print(msg);
            String str = sc.nextLine();
            if (str.matches(regex)) {
                return str;
            } else {
                System.out.println(err);
            }
        }
    }

    public RankOfGraduation checkRank(String msg, String err) {
        while (true) {
            System.out.print(msg);
            String str = checkString(msg, err, ".+");
            RankOfGraduation rankOfGraduation = RankOfGraduation.getRankOfGraduation(str);
            if (rankOfGraduation != null) {
                return rankOfGraduation;
            } else {
                System.out.println(err);
            }
        }
    }

    public CandidateType checkCandidateType(String msg, String err) {
        while (true) {
            System.out.print(msg);
            int type = checkInt(msg, err, 0, 2);
            if (CandidateType.getCandidateTypeByID(type) != null) {
                return CandidateType.getCandidateTypeByID(type);
            }
        }
    }

}
