/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.util.ArrayList;
import java.util.Hashtable;
import mode.Fruit;
import mode.OrderDetail;

/**
 *
 * @author dotha
 */
public class Manager {

    private ArrayList<Fruit> orderDetails;
    private Hashtable<String, ArrayList<OrderDetail>> hashtable;

    public Manager() {
        this.orderDetails = new ArrayList<>();
        this.hashtable = new Hashtable<>();

    }

    public String addFruit(String id, String name, double price, int quantity, String origin) {
        Fruit newFruit = new Fruit(id, name, price, quantity, origin);
        orderDetails.add(newFruit);
        return id;
    }

    public Fruit findFruitById(String id) {
        for (Fruit orderDetail : orderDetails) {
            if (orderDetail.getId().equalsIgnoreCase(id)) {
                return orderDetail;
            }
        }
        return null;
    }

    public Fruit findFruitByName(String name) {
        for (Fruit orderDetail : orderDetails) {
            if (orderDetail.getName().equalsIgnoreCase(name)) {
                return orderDetail;
            }
        }
        return null;
    }

    public void listAllFruit() {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (Fruit orderDetail : orderDetails) {
            System.out.println(orderDetail.printFruit());
        }
    }

    public ArrayList<OrderDetail> addOrderList(Fruit fruit, int quantity, ArrayList<OrderDetail> orderList) {
        if (fruit.getQuantity() < quantity) {
            System.out.println(fruit.getName() + " Has " + fruit.getQuantity() + " Left");
            return null;
        }
        if (fruit.getQuantity() > 0) {
            orderList.add(new OrderDetail(fruit, quantity));
            fruit.setQuantity(fruit.getQuantity() - quantity);
        }
        return orderList;
    }

    public int listTotal(Fruit f, int quantity, ArrayList<OrderDetail> orderList) {
        int total = 0;
        System.out.println("| Product | Quantity | Price | Amount");
        for (OrderDetail orderDetail : orderList) {
            System.out.printf("%5s %10s %10s %s\n", orderDetail.getFruit().getName(), orderDetail.getQuantity(), orderDetail.getFruit().getPrice(), orderDetail.getQuantity() * orderDetail.getFruit().getPrice());
            total += orderDetail.getQuantity() * orderDetail.getFruit().getPrice();
        }
        return total;
    }

    public String addIntohashtable(String name, Fruit fruit, int quantity, ArrayList<OrderDetail> orderList) {
        hashtable.put(name, orderList);
        return name;
    }

    public void printHashTable() {
        for (String key : hashtable.keySet()) {
            double total = 0;
            int tt = 1;
            System.out.println("Customer: " + key);
            for (OrderDetail od : hashtable.get(key)) {
                System.out.println(tt + "." + od.printOrder());
                tt++;
                total += od.getQuantity() * od.getFruit().getPrice();
            }
            System.out.println("Total: " + total);
            System.out.println();
        }
    }

    public boolean checkHashTable() {
        return hashtable.isEmpty();
    }

    public boolean checkFruiList() {
        return orderDetails.isEmpty();
    }

}
