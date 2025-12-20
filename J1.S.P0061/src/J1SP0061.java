
import Shape.Circle;
import Shape.Rectangle;
import Shape.Triangle;
import java.util.Scanner;

public class J1SP0061 {

    private static final Scanner sc = new Scanner(System.in);

    // kiểm tra điều kiện xem hàm nhập vào không được null
    private static double checkInput() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Re-input");
            }
        }
    }

    // nhập vào của tam giác và điều kiện
    private static Triangle inputTriangle() {
        while (true) {
            System.out.println("Please input side A of Triangle: ");
            double a = checkInput();
            System.out.println("Please input side B of Triangle: ");
            double b = checkInput();
            System.out.println("Please input side C of Triangle: ");
            double c = checkInput();
            if (a + b >= c && a + c >= b && b + c >= a) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Re-input: ");
            }
        }
    }

    private static Circle inputCircle() {
        while (true) {
            System.out.println("Please input radius of Circle: ");
            double radius = checkInput();
            return new Circle(radius);
        }
    }
    
    
    
    private static Rectangle inputRectangle() {
        while (true) {
            System.out.println("Please input side width of Rectangle: ");
            double width = checkInput();
            System.out.println("Please input length of Rectangle: ");
            double length = checkInput();
            return new Rectangle(width, length);
        }
    }
    
    private static void disPlay(Rectangle rectangle, Circle circle, Triangle triangle){
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }
    

    public static void main(String[] args) {
        System.out.println("=====Calculator Shape Program=====");
        Rectangle rectangle = inputRectangle();
        Circle circle = inputCircle();
        Triangle triangle = inputTriangle();
        
        disPlay(rectangle, circle, triangle);
    }
    

}
