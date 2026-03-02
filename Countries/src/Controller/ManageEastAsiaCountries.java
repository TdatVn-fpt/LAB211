/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.EastAsiaCountries;
import Util.Validation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ManageEastAsiaCountries {
      private Validation valid;
    private List<EastAsiaCountries> listAsiaCountry;
    public ManageEastAsiaCountries() {
        valid = new Validation();
        listAsiaCountry = new ArrayList<>();
    }
    public void addCountryInformation(EastAsiaCountries country){
        if (country != null) {
            listAsiaCountry.add(country);
        }
    }
    
      public List<EastAsiaCountries> getRecentlyEnteredInformation(){
        return new ArrayList<>(listAsiaCountry);
    }

          public List<EastAsiaCountries> searchInformationByString(String string){
        List<EastAsiaCountries> result = new ArrayList<>();
        for (EastAsiaCountries c : listAsiaCountry) {
            if (c.getCountryName().contains(string) ||c.getCountryTerrain().contains(string) ) {
                result.add(c);
            }
        }
        return result;
    }
              public void sortInformationByAscendingOrder(){
        for (int i = 0; i < listAsiaCountry.size() - 1; i++) {
            for (int j = i + 1; j < listAsiaCountry.size(); j++) {
                String name1 = listAsiaCountry.get(i).getCountryName();
                String name2 = listAsiaCountry.get(j).getCountryName();

                if (name1.compareToIgnoreCase(name2) > 0) {
                    EastAsiaCountries temp = listAsiaCountry.get(i);
                    listAsiaCountry.set(i, listAsiaCountry.get(j));
                    listAsiaCountry.set(j, temp);
                }
            }
        }
    }
              
              
    public boolean checkCodeExist(String countryCode) {
        for (EastAsiaCountries c : listAsiaCountry) {
            if (c.getCountryCode().equalsIgnoreCase(countryCode)) {
                return true;
            }
        }
        return false;
    }
        public void clearCountryList() {
        listAsiaCountry.clear();
    }
        
            public void displayInformationOfCountry() {
        if (listAsiaCountry == null || listAsiaCountry.size() == 0) {
            System.out.println("LIST IS EMPTY....");
            return;
        }
        System.out.printf("%-15s %-15s %-15s %-15s", "Code", "Name", "Total Area", "Terrain");
        System.out.println("");
        for (EastAsiaCountries ob : listAsiaCountry) {
            ob.display();
            System.out.println();
        }
    }
                public EastAsiaCountries getCountryByIndex(int index){
        for (int i = 0; i < listAsiaCountry.size() - 1; i++) {
            if(index  == i){
                return listAsiaCountry.get(i);
            }
        }
        return null;
    }
    
}
