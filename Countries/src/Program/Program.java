/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Program;

import Controller.ManageEastAsiaCountries;
import Model.EastAsiaCountries;
import Util.Validation;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Program {
        public static void main(String[] args) {
    Validation valid = new Validation();
        ManageEastAsiaCountries pro = new ManageEastAsiaCountries();
        while (true) {            
            System.out.println("========== MENU ==========");
            System.out.println("1. Input the information of 11 countries in East Asia");
            System.out.println("2. Display the information of country you've just input");
            System.out.println("3. Search the information of country by user-entered string");
            System.out.println("4. Display the information of countries sorted name in ascending order");
            System.out.println("5. Exit");
            int choice = valid.checkInputInt("Enter your choice : ", 1, 5);
            switch (choice) {
                case 1:
                    pro.clearCountryList();
                    for (int i = 1; i < 12; i++) {
                    System.out.println("Enter information for country " + i);
                    String code;
                    while (true) {            
                        code = valid.checkInputString("Enter code of country: ");
                        if(pro.checkCodeExist(code) == false){// code ko tồn tại
                            break;
                        }
                        System.out.println("ERROR BECAUSE CODE IS EXIST....");
                    }
                    String name = valid.checkInputString("Enter name of country: ");
                    double totalArea = valid.checkTotalArea("Enter total Area: ", 0);
                    String terrian = valid.checkInputString("Enter terrain of country: ");
                    try {
                        EastAsiaCountries newCountry = new EastAsiaCountries(terrian, code, name, totalArea);
                        pro.addCountryInformation(newCountry);
                        System.out.println("SUCCESSFULLY FOR " + i + " TIME");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Fail input because object is error due to some method....");
                    }
                }
                    break;
                case 2:
                    int index = pro.getRecentlyEnteredInformation().size() - 1; // vị trí index cuối
                    EastAsiaCountries receive = pro.getCountryByIndex(index);
                    if(receive == null){
                        System.out.println("LIST IS EMPTY");
                        break;
                    }
                    System.out.printf("%-15s %-15s %-15s %-15s", "Code", "Name", "Total Area", "Terrain");
                    System.out.println("");
                    System.out.printf("%-15s %-15s %-15.1f %-15s/n",receive.getCountryCode(),
                                                           receive.getCountryName(),
                                                           receive.getTotalArea(),
                                                           receive.getCountryTerrain());
                    System.out.println("");
                    break;
                case 3:
                    String name = valid.checkInputString("Enter the string you want to search for: ");
                    List<EastAsiaCountries> out = pro.searchInformationByString(name);
                    if(out.isEmpty()){
                        System.out.println("The String not exist....");
                        break;
                    }
                    pro.displayInformationOfCountry();
                    break;
                case 4:
                    pro.sortInformationByAscendingOrder();
                    pro.displayInformationOfCountry();
                    break;
                case 5:
                    System.out.println("Exiting");
                    return;
            }
        }
    }
}
