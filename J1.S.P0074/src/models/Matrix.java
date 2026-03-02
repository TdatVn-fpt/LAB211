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
public class Matrix {

    private int row, column;
    private double[][] data;

    public Matrix() {
    }

    public Matrix(int row, int column) throws Exception {
        setColumn(column);
        setRow(row);
        data = new double[row][column];
    }

    public void setRow(int row) throws Exception {
        if (row <= 0) {
            throw new Exception("Row must be positive number !!!!");
        } else {
            this.row = row;
        }
    }

    public void setColumn(int column) throws Exception {
        if (column <= 0) {
            throw new Exception("Row must be positive number !!!!");
        } else {
            this.column = column;
        }
    }

    public void setElement(int i, int j, double value) throws Exception {
        if (i < 0 || j < 0) {
            throw new Exception("index is Erorr!!!");
        } else {
            data[i][j] = value;
        }

    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public double getElement(int i, int j) {
        return data[i][j];
    }

    public Matrix addMatrix(Matrix other) throws Exception {
        Matrix result = new Matrix();
        if (other.getRow() != this.row) {
            throw new Exception("Number of row not valid");
        } else if (other.getColumn() != this.column) {
            throw new Exception("Number of column not valid");
        } else {
            result = new Matrix(other.row, other.column);
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.column; j++) {
                    double value = data[i][j] + other.getElement(i, j);
                    result.setElement(i, j, value);
                }
            }
        }
        return result;
    }

    public Matrix subtractMatrix(Matrix other) throws Exception {
        Matrix result = new Matrix();
        if (other.getRow() != this.row) {
            throw new Exception("Number of row not valid");
        } else if (other.getColumn() != this.column) {
            throw new Exception("Number of row not valid");
        } else {
            result = new Matrix(other.row, other.column);
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.column; j++) {
                    double value = data[i][j] - other.getElement(i, j);
                    result.setElement(i, j, value);
                }
            }
        }
        return result;
    }

    public Matrix multipleMatrix(Matrix other) throws Exception {
        Matrix result = null;
        if (this.column != other.getRow()) {
            throw new Exception("The row of Matrix 1 must be equal the column of Matrix 2 !!!");
        } else {
            result =  new Matrix(this.row, other.column);
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < other.column; j++) {
                    double value = 0;
                    for (int k = 0; k < this.column; k++) {
                        value += data[i][k] * other.getElement(k, j);
                    }
                    result.setElement(i, j, value);

                }
            }
        }
        return result;
    }
}
