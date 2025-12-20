
import Shape.Circle;
import Shape.Magric_modifier;
import Shape.Rectangle;
import Shape.Shape;
import Shape.Square;
import Shape.Triangle;
import java.util.Scanner;

public class J1SP0061 {
/**
 * static giúp tạo ra duy nhất một bản sao dùng chung cho tất cả các hàm trong lớp đó.
 * final ở đây sẽ được hiểu là tính bất biến
 */
    private static final Scanner sc = new Scanner(System.in);

    private static double checkInput() {
        while (true) {
            try {
                //parse có nhiệm vụ "ép" chuyển đổi chuỗi sang số thực ví dụ "12.5" thành 12.5
                double result = Double.parseDouble(sc.nextLine());
                // Kiểm tra số dương( Validation)   
                if (result <= 0) {
                    System.out.println("Please input a number > 0");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }
// quy tắc camel case chữ cái đầu viết thường, chữ cái tiếp theo của từ tiếp theo viết hoa
   //Nếu bạn chỉ đặt tên là Rectangle(), Java sẽ hiểu lầm đó là một hàm khởi tạo (Constructor).
    // nhập vào của tam giác và điều kiện
    
    // ví dụ nếu ta bỏ static ở các hàm này, các hàm này sẽ trở thành phương thức của đối tượng(Instance Methods)
    // thay vì phương thức của lớp
    private static Triangle inputTriangle() {
        while (true) {
            System.out.println("Please input side A of Triangle: ");
            double a = checkInput();
            System.out.println("Please input side B of Triangle: ");
            double b = checkInput();
            System.out.println("Please input side C of Triangle: ");
            double c = checkInput();
            if (a + b > c && a + c > b && b + c > a) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Please input a valid number: ");
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
    
     private static Square inputSquare() {
        while (true) {
            System.out.println("Please input canh of Square: ");
            double canh = checkInput();
            return new Square(canh);
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
//
//    private static void disPlay(Rectangle rectangle, Circle circle, Triangle triangle) {
//        rectangle.printResult();
//        circle.printResult();
//        triangle.printResult();
//    }

    public static void main(String[] args) {
        System.out.println("=====Calculator Shape Program=====");
//        Rectangle rectangle = inputRectangle();
//        Circle circle = inputCircle();
//        Triangle triangle = inputTriangle();
//        
//        disPlay(rectangle, circle, triangle);
/**
 * áp dụng tính chất đa hình và trừu tượng vào hàm main
 * dù shape là lớp trừu tượng vẫn có thể khai báo mảng kiểu shape để chứa lớp con của nó
 * vòng for là tính đa hình mặc dù biến s có kiểu là shape , khi chạy thì java vẫn kiểm tra xem nó thực sự là hình gì
 * ví dụ nếu s là rectangle sẽ gọi hàm printResult() của lớp rectangle
 */
        Shape[] shapes = new Shape[4];
        shapes[0] = inputRectangle();
        shapes[1] = inputCircle();
        shapes[2] = inputTriangle();
        shapes[3] = inputSquare();

        for (Shape s : shapes) {
            s.printResult();
        }
        Magric_modifier ms = new Magric_modifier(10);
        ms.testProtected();
    }

}

/**
 * Cách khắc phục: Bạn phải khởi tạo một đối tượng của chính lớp đó rồi mới gọi hàm được:

public static void main(String[] args) {
    J1SP0061 app = new J1SP0061(); // Phải tạo đối tượng app
    Shape rectangle = app.inputRectangle(); // Gọi qua app
    // ...
}
 */