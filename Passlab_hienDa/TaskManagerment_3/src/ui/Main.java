package ui;

import bo.TaskInputer;
import controller.Controller;
import entity.Task;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        Controller control = new Controller();
        while (true) {
            int choice = Validator.getInt("========= Task program =========\n"
                    + "1.	Add Task\n"
                    + "2.	Delete task\n"
                    + "3.	Display Task\n"
                    + "4.	exit\n"
                    + "Enter your choice: ", "Just 1-> 4", "Invalid!", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("------------Add Task------------");
                    try {
                        TaskInputer inputer = new TaskInputer();
                        Task task = inputer.input();
                        int IDTask = control.add(task);
                        System.out.println("Add success task id: " + IDTask);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("------------Del Task------------");
                    try {
                        int id = Validator.getInt("Task ID: ", "Error range!", "Invalid!",
                                Integer.MIN_VALUE, Integer.MAX_VALUE);
                        control.delete(id);
                        System.out.println("Delete success:");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("------------Show Task------------");
                    try {
                        control.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

}
