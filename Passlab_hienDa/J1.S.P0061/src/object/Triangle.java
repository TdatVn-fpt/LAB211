package object;

import operation.Validation;

public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    @Override
    public void printResult() {
        System.out.println("-------Triangle-----");
        System.out.println("Side A:" + getSideA());
        System.out.println("Side B:" + getSideB());
        System.out.println("Side C:" + getSideC());
        System.out.println("Area" + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    @Override
    public double getPerimeter() {
        return (sideA + sideB + sideC);
    }

    @Override
    public double getArea() {
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public void input() {
        sideA = Validation.checkDouble("Please input side A of Triangle:", 1, Double.MAX_VALUE);
        sideB = Validation.checkDouble("Please input side B of Triangle:", 1, Double.MAX_VALUE);
        sideC = Validation.checkDouble("Please input side C of Triangle:", 1, Double.MAX_VALUE);

        while (true) {
            if (checkTriangle()) {
                setSideA(sideA);
                setSideB(sideB);
                setSideC(sideC);
                return;
            } else{
                System.out.print("Please input again Triangle:");
            }
        }

    }

    private boolean checkTriangle() {
        if (sideA + sideB > sideC && sideB + sideC > sideA && sideA + sideC > sideB) {
            return true;
        }
        return false;
    }

}
