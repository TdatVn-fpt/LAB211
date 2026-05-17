/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dotha
 */
public enum RankOfGraduation {
    
    EXCELLENCE("Excellence"),
    GOOD("Good"),
    FAIR("Fair"),
    POOR("Poor");
    
    private String rankOfGraduation;
    
    private RankOfGraduation(String rankOfGraduation) {
        this.rankOfGraduation = rankOfGraduation;
    }
    
    public String getRankOfGraduationString() {
        return rankOfGraduation;
    }
    
    public static RankOfGraduation getRankOfGraduation(String str) {
        for (RankOfGraduation value : values()) {
            if (value.getRankOfGraduationString().equalsIgnoreCase(str)) {
                return value;
            }
        }
        return null;
    }
    
}
