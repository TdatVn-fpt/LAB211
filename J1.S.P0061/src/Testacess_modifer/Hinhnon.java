
package Testacess_modifer;

import Shape.Shape;


public class Hinhnon extends Shape{
    protected double radius;

    public Hinhnon() {
    }

    public Hinhnon(double radius) {
        this.radius = radius;
    }
    
    

    @Override
    public void printResult() {
        System.out.println("Area of hinh non: ");
    }

    @Override
    public double getPerimeter() {
       return Math.PI * 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;          
    }
}