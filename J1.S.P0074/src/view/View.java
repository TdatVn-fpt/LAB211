/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matran.view;

import matran.model.Matrix;
import matran.util.Validation;

/**
 *
 * @author Hieu
 */
public class View {

    private Validation vali = new Validation();

    public int getChoice() {
        System.out.println("=======MATRIX CACULATE======");
        System.out.println("1.Addition Matrix");
        System.out.println("2.Subtraction Matrix");
        System.out.println("3.Multiple Matrix");
        System.out.println("4.Exit");
        return vali.getInt("Choice");
    }

    public Matrix inputMatrix(String str) throws Exception {

        System.out.println(str);
        int row = vali.getPositiveInt("row");
        int col = vali.getPositiveInt("column");

        Matrix matrix = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix.setElement(i, j, vali.getDouble("Element[" + i + "][" + j + "] : "));
            }
        }
        return matrix;
    }

    public void displayMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getRow(); i++) {
            for (int j = 0; j < matrix.getColumn(); j++) {
                System.out.print("[" + matrix.getElement(i, j) + "] ");
            }
            System.out.println("");
        }
    }

    public void Results(Matrix matrix1, Matrix matrix2, Matrix result, char str) {
        displayMatrix(matrix1);
        System.out.println(" " + str + " ");
        displayMatrix(matrix2);
        System.out.println(" = ");
        displayMatrix(result);
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
