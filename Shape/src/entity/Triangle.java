package entity;

import utils.Validator;

public class Triangle extends Shape {

    private double a, b, c;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("re-input");
        }
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        if (b <= 0) {
            throw new IllegalArgumentException("re-input");
        }
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        if (c <= 0) {
            throw new IllegalArgumentException("re-input");
        }
        this.c = c;
    }

    public Triangle(double a, double b, double c) {
        // kiểm tra điều kiện tam giác
        if (a + b <= c || b + c <= a || c + a <= b) {
            throw new IllegalArgumentException("Dữ liệu cạnh tam giác không hợp lệ!");
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void input() {
        while (true) {
            a = Validator.getDouble("Enter side A: ", 0);
            b = Validator.getDouble("Enter side B: ", 0);
            c = Validator.getDouble("Enter side C: ", 0);
            if ((a + b > c) && (a + c > b) && (b + c > a)) {
                break; // Thỏa mãn thì thoát vòng lặp
            }
            System.out.println("Lỗi: Ba cạnh này không tạo thành một tam giác!");
        }
    }

    @Override
    public void printResult() {
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        System.out.println("Triangle - A: " + a
                + ", B: " + b
                + ", C: " + c
                + ", Area: " + area
                + ", Perimeter: " + (a + b + c)
        );
    }
}
