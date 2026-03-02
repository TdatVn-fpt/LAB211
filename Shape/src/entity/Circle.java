package entity;

import utils.Validator;

public class Circle extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        this.radius = radius;
    }


    public Circle(double radius) {
        setRadius(radius);
        this.radius = radius;
    }

    @Override
    public void input() {
        radius = Validator.getDouble("Enter radius: ", 0);
    }

    @Override
    public void printResult() {
        System.out.println("Circle - Radius: " + radius 
            + ", Area: " + (Math.PI * radius * radius)
            + ",Perimeter: " + (Math.PI * 2 * radius)
        );
    }
}
