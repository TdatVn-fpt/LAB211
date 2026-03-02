/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Country {
    protected String countryCode;
    protected String countryName;
    protected double totalArea;

    public Country() {
    }

    public Country(String countryCode, String countryName, double totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        setTotalArea(totalArea);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        if(totalArea <= 0){
            throw new IllegalArgumentException();
        }
        this.totalArea = totalArea;
    }
    public void display(){
        System.out.printf("%-15s %-15s %-15.1f/n",countryCode,countryName,totalArea
                                                           );
    }

}
