
package object;

import operation.Validation;


public class Circle extends Shape{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        setRadius(radius);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            System.out.println("Radius have to positve number: ");
        }
        this.radius = radius;
    }
    
    
    @Override
    public void printResult() {
        System.out.println("-----Circle-----");
        System.out.println("Radius:" + getRadius());
        System.out.println("Area:" + getArea());
        System.out.println("Perimeter:" + getPerimeter());
        }

    @Override
    public double getPerimeter() {
     return Math.PI * 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void input() {
     radius = Validation.checkDouble("Please input radius of Circle:", 1, Double.MAX_VALUE);
    }
    
}
