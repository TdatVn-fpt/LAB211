/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;
import model.Item;
import utils.Validator;

/**
 *
 * @author Tuan Tran
 */
public class FruitView {

    // Hiển thị menu chính của hệ thống 
    public void displayMenu() {
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
    }

    // Hiển thị danh sách trái cây theo định dạng bảng (chỉ hiển thị những trái có số lượng >0) 
    public void displayListFruit(ArrayList<Fruit> listFruit) {
        System.out.println("+------+--------------------+--------------------+------------+------------+");
        System.out.printf("|%-6s|%-20s|%-20s|%-12s|%-12s|\n", "No.", "Fruit Name", "Origin", "Price", "Quantity");
        System.out.println("+------+--------------------+--------------------+------------+------------+");
        int stt = 1;
        for (Fruit f : listFruit) {
            System.out.printf("|%-6d|%-20s|%-20s|%11.1f$|%12d|\n",
                    stt++, f.getFruitName(), f.getOrigin(), f.getPrice(), f.getQuantity());
        }
        System.out.println("+------+--------------------+--------------------+------------+------------+");
    }

    // Hiển thị hóa đơn sau khi khách hàng chọn mua xong
    public void displayOrder(ArrayList<Item> cart) {
        double total = 0;
        System.out.println("+------+--------------------+------------+------------+------------+");
        System.out.printf("|%-6s|%-20s|%-12s|%-12s|%-12s|\n", "No.", "Product", "Quantity", "Price", "Amount");
        System.out.println("+------+--------------------+------------+------------+------------+");
        int stt = 1;
        for (Item item : cart) {
            System.out.printf("|%-6d|%-20s|%12d|%11.1f$|%11.1f$|\n",
                    stt++, item.getFruitName(), item.getQuantity(), item.getPrice(), item.getAmount());
            total += item.getAmount();
        }
        System.out.println("+------+--------------------+------------+------------+------------+");
        System.out.printf(" Total: %47.1f$\n", total);
    }

    // Hiển thị tất cả các đơn hàng trong hệ thống (dành cho chức năng View Orders) 
    public void displayAllOrders(Hashtable<String, ArrayList<Item>> orders) {
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }
        for (String customer : orders.keySet()) {
            System.out.println("Customer: " + customer.toUpperCase());
            displayOrder(orders.get(customer));
            System.out.println();
        }
    }

    // Các phương thức nhận dữ liệu sử dụng Validator 
    public int getMenuChoice() {
        return Validator.getInt("Enter your choice: ", "Please enter 1-4.", "Invalid number.", 1, 4);
    }

    public String inputFruitId() {
        return Validator.getString("Enter fruit id: ", "Cannot be empty.", "^.+$");
    }

    public String inputFruitName() {
        return Validator.getString("Enter fruit name: ", "Cannot be empty.", "^.+$");
    }

    public double inputPrice() {
        return Validator.getDouble("Enter price: ", "Price must be > 0 and <= 1000", "Invalid price.", 0.1, 1000);
    }

    public int inputQuantity() {
        return Validator.getInt("Enter quantity: ", "Quantity must be > 0 and <= 1000", "Invalid quantity.", 1, 1000);
    }

    public String inputOrigin() {
        return Validator.getString("Enter origin: ", "Cannot be empty.", "^.+$");
    }

    public String inputCustomerName() {
        return Validator.getString("Enter customer name: ", "Invalid name.", "^[a-zA-Z\\s]+$");
    }

    public boolean inputContinue(String message) {
        String result = Validator.getString(message, "Please enter Y or N.", "^[YyNn]$");
        return result.equalsIgnoreCase("Y");
    }

    public int inputItemSelection(int max) {
        return Validator.getInt("Enter item (Enter 0 to exit!): ", "Out of range.", "Invalid number.", 0, max);
    }
}
