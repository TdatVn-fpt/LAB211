/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matran.controller;

import matran.model.Matrix;
import matran.model.MatrixCaculator;
import matran.view.View;

/**
 *
 * @author Hieu
 */
public class Controller {

    private MatrixCaculator model;
    private View view;

    public Controller(MatrixCaculator model, View view) {
        this.model = model;
        this.view = view;
    }

    public void handMatrixOperator(char Operator) {
        try {
            Matrix m1 = view.inputMatrix("The Firt Matrix");
            Matrix m2 = view.inputMatrix("The Second Matrix");
            Matrix result = model.MatrixOperation(m1, m2, Operator);
            view.Results(m1, m2, result, Operator);
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    public void run() {
        while (true) {
            int choice = view.getChoice();
            switch (choice) {
                case 1:
                    handMatrixOperator('+');
                    break;
                case 2:
                    handMatrixOperator('-');
                    break;
                case 3:
                    handMatrixOperator('*');
                    break;
                default:

                    return;
            }
        }
    }
}
