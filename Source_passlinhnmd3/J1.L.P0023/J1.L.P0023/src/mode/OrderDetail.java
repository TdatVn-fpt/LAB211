/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mode;


/**
 *
 * @author dotha
 */
public class OrderDetail {

    private Fruit fruit;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return fruit.toString() + String.format("%s", quantity);
    }
    
    public String printOrder() {
        return String.format("%s %s %s$ %s$", fruit.getName(), quantity, fruit.getPrice(), quantity * fruit.getPrice());
    }
    

}
