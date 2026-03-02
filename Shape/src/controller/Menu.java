package controller;

import entity.*;
import utils.Validator;

public class Menu {

    private Controller controller = new Controller();

    public void run() {
        while (true) {
            System.out.println("\n--- SHAPE MANAGEMENT ---");
            System.out.println("1. Add Shape");
            System.out.println("2. Update Shape");
            System.out.println("3. Delete Shape");
            System.out.println("4. Display Shapes");
            System.out.println("5. Exit");

            int choice = Validator.getInt("Choose: ", 1, 5);

            switch (choice) {
                case 1:
                    addShape();
                    break;
                case 2:
                    updateShape();
                    break;
                case 3:
                    deleteShape();
                    break;
                case 4:
                    controller.display();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private Shape chooseShape() {
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");

        int type = Validator.getInt("Choose type: ", 1, 3);

//        Shape s = switch (type) {
//            case 1 -> new Circle();     
//            case 2 -> new Rectangle();  
//            default -> new Triangle();  
//        };
        Shape s = null;
        switch (type) {
            case 1:
                 s = new Circle(1.0);
                break;
            case 2:
                s = new Rectangle(1.0,2.0);
                break;
            case 3:
                s = new Triangle(1.0,1.0,1.0);
            break;
        }
        s.input();
        return s;
        
    }

    

    private void addShape() {
        Shape s = chooseShape();
        controller.add(s);
    }

    private void updateShape() {
        if (controller.size() == 0) {
            System.out.println("List empty!");
            return;
        }

        controller.display();
        int index = Validator.getInt("Index to update: ", 0, controller.size() - 1);

        Shape newShape = chooseShape();
        controller.update(index, newShape);
    }

    private void deleteShape() {
        if (controller.size() == 0) {
            System.out.println("List empty!");
            return;
        }

        controller.display();
        int index = Validator.getInt("Index to delete: ", 0, controller.size() - 1);

        controller.delete(index);
    }
}
