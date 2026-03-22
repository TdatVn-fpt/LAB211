/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matran;

import matran.controller.Controller;
import matran.model.MatrixCaculator;
import matran.view.View;

/**
 *
 * @author Hieu
 */
public class MaTran {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MatrixCaculator model = new MatrixCaculator();
        View view = new View();
        Controller c = new Controller(model, view);
        c.run();
    }
    
}
