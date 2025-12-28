package operation;

import object.Circle;
import object.Rectangle;
import object.Shape;
import object.Triangle;

public class Menu {

    Shape rectangle = new Rectangle(); // tham chiếu tới áp dụng tính đa hình gọi các phương thức có trong rectangle
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
