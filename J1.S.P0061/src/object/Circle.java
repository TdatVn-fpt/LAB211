package object;

import operation.Validation;

public class Circle extends Shape {

    private double radius;

    @Override
    public void printResult() {
        System.out.println("----- Cirlce -----");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public void input() {
        radius = Validation.checkDouble("Please input radius of Circle:", 1, Double.MAX_VALUE);

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
