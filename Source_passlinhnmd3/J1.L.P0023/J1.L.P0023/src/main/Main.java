/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controler.Manager;
import util.Validate;
import view.Show;

/**
 *
 * @author dotha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Validate vld = new Validate();
        Manager mng = new Manager();
        Show show = new Show(vld, mng);
        show.Menu();
    }
    
}
