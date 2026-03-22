package object;

import operation.Validation;

public class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.println("Width:" + getWidth());
        System.out.println("Length" + getLength());
        System.out.println("Area:" + getArea());
        System.out.println("Perimeter:" + getPerimeter());

    }

    @Override
    public double getPerimeter() {
        return (width + length) * 2;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public void input() {
        width = Validation.checkDouble("Please input side width of Rectangle:", 1, Double.MAX_VALUE);
        length = Validation.checkDouble("Please input length of Rectangle:", 1, Double.MAX_VALUE);
    }

}
