/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controler.Manager;
import java.util.ArrayList;
import mode.Fruit;
import mode.OrderDetail;
import util.Validate;

/**
 *
 * @author dotha
 */
public class Show {

    private Validate vld;
    private Manager mng;

    public Show(Validate vld, Manager mng) {
        this.vld = vld;
        this.mng = mng;
    }

    public void Menu() {
        while (true) {
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("   1. Create Fruit");
            System.out.println("   2. View Orders");
            System.out.println("   3. Shopping (For Buyer)");
            System.out.println("   4. Exit");
            int menu = vld.checkInt("Enter: ", "Invalid Input!", 1, 4);
            switch (menu) {
                case 1:
                    addFruitUI();
                    break;
                case 2:
                    viewOrderUI();
                    break;
                case 3:
                    shoppingUI();
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }
    }

    public void addFruitUI() {
        mng.addFruit("F001", "Apple", 3.5, 50, "USA");
        mng.addFruit("F002", "Banana", 1.2, 100, "Vietnam");
        mng.addFruit("F003", "Orange", 2.8, 60, "Thailand");
        mng.addFruit("F004", "Mango", 4.0, 40, "Philippines");
        mng.addFruit("F005", "Grape", 5.5, 30, "Australia");
        mng.addFruit("F006", "Watermelon", 2.0, 25, "Vietnam");
        mng.addFruit("F007", "Dragon Fruit", 3.0, 40, "Vietnam");
        mng.addFruit("F008", "Kiwi", 6.2, 15, "New Zealand");
        mng.addFruit("F009", "Pineapple", 2.5, 35, "Thailand");

        String yesno;
        do {
            String id = vld.checkString("Enter Id: ", "Invalid Input!", ".+");
            String name = vld.checkString("Enter Name: ", "Invalid Input!", ".+");
            double price = vld.checkDouble("Enter Price: ", "Invalid Price!", 0, Double.MAX_VALUE);
            int quantity = vld.checkInt("Enter Quantity: ", "Invalid Input!", 0, Integer.MAX_VALUE);
            String origin = vld.checkString("Enter Origin: ", "Invalid!", ".+");
            System.out.println("Add Success with Id " + mng.addFruit(id, name, price, quantity, origin));
            yesno = vld.checkString("Do you want to continue (Y/N): ", "invalid input!", "[yYnN]");
        } while (yesno.equalsIgnoreCase("y"));
    }

    public void viewOrderUI() {
        if (mng.checkHashTable()) {
            System.out.println("Order List is Empty!");
            return;
        }
        mng.printHashTable();
    }

    public void shoppingUI() {
        if (mng.checkFruiList()) {
            System.out.println("Fruit List is Empty!");
            return;
        }
        mng.listAllFruit();
        System.out.println();
        String yesno = "null";
        int quantity;
        Fruit fruit;
        ArrayList<OrderDetail> orderList = new ArrayList<>();
        do {
            String name = vld.checkString("You Selected: ", "Invalid input!", ".+");
            quantity = vld.checkInt("Please input quantity: ", "Invalid quantity!", 0, Integer.MAX_VALUE);
            fruit = mng.findFruitByName(name);
            if (fruit == null) {
                System.out.println("Name does not exist!");
            } else {
                mng.addOrderList(fruit, quantity, orderList);
            }
            yesno = vld.checkString("Do you want to continues (Y/N): ", "Invalid Input!", "[yYnN]");
        } while (yesno.equalsIgnoreCase("y"));
        mng.listTotal(fruit, quantity, orderList);
        String nameCustomer = vld.checkString("Input Your name: ", "Invalid Inut!", ".+");
        if (fruit != null) {
            System.out.println("Add success with name " + mng.addIntohashtable(nameCustomer, fruit, quantity, orderList));
        }
    }

}
