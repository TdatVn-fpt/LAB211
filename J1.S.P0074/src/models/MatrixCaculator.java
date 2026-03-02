/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matran.model;

/**
 *
 * @author Hieu
 */
public class MatrixCaculator {

    public Matrix MatrixOperation(Matrix m1, Matrix m2, char str) throws Exception {
        Matrix result = null;
        switch (str) {
            case '+':
                result = m1.addMatrix(m2);
                break;
            case '-':
                result = m1.subtractMatrix(m2);
                break;
            case '*':
                result = m1.multipleMatrix(m2);
                break;

        }
        return result;
    }
}
