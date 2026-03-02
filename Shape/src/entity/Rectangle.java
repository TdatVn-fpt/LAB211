package entity;

import utils.Validator;

public class Rectangle extends Shape {
    private double width, height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0) {
            throw new IllegalArgumentException("re-input");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
         if (height > 0) {
            throw new IllegalArgumentException("re-input");
        }
        this.height = height;
    }



    public Rectangle(double width, double height) {
        if (width >= height) {
            throw new IllegalArgumentException("Chiều dài phải lớn hơn chiều rộng");
        }
        
        this.width = width;
        this.height = height;
    }

    @Override
    public void input() {
        while (true) {            
            width = Validator.getDouble("Enter width: ", 0);
        height = Validator.getDouble("Enter height: ", 0);
            if (height >= width) {
                break;
            }
            System.out.println("Lỗi chiều dài(height) phải lớn hơn chiều rộng(width): ");
        }
    }

    @Override
    public void printResult() {
        System.out.println("Rectangle - W: " + width 
            + ", H: " + height 
            + ", Area: " + (width * height)
            + ", Perimeter: " + (width + height) * 2
        );
    }
}
