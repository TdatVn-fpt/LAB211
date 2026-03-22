package operation;

import object.Circle;
import object.Rectangle;
import object.Shape;
import object.Triangle;



public class Menu {

    Shape rectangle = new Rectangle();
    Shape circle = new Circle();
    Shape triangle = new Triangle();

    public void inputProgram() {
        rectangle.input();
        circle.input();
        triangle.input();
    }

    public void display() {
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }
}
