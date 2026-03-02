package controller;

import entity.Shape;
import java.util.ArrayList;

public class Controller {
    private ArrayList<Shape> list = new ArrayList<>();

    public void add(Shape s) {
        list.add(s);
        System.out.println("Added successfully!");
    }

    public void update(int index, Shape newShape) {
        list.set(index, newShape);
        System.out.println("Updated successfully!");
    }

    public void delete(int index) {
        list.remove(index);
        System.out.println("Deleted successfully!");
    }

    public void display() {
        if (list.isEmpty()) {
            System.out.println("No shapes found!");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print("[" + i + "] ");
            list.get(i).printResult();
        }
    }

    public int size() {
        return list.size();
    }
}
