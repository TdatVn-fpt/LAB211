package Shape;

public class Square extends Shape {

    private double canh;

    public Square() {
    }

    public Square(double canh) {
        this.canh = canh;
    }

    public double getCanh() {
        return canh;
    }

    public void setCanh(double canh) {
        this.canh = canh;
    }

    @Override
    public double getPerimeter() {
        return canh * canh;
    }

    @Override
    public double getArea() {
        return canh * 4;
    }

    @Override
    public void printResult() {
        System.out.println("-----Square-----");
        System.out.println("Square: " + canh);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
