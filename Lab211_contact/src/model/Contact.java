package model;

public class Contact {
    private static int autoId = 1; 
    
    private int id;
    private String fullName;
    private String firstName;
    private String lastName;
    private String group;
    private String address;
    private String phone;

    public Contact(String fullName, String group, String address, String phone) {
        this.id = autoId++; 
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
        splitName(fullName);
    }

    private void splitName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.firstName = "";
            this.lastName = "";
            return;
        }
        name = name.trim();
        int firstSpace = name.indexOf(" ");
        if (firstSpace == -1) {
            this.firstName = name; 
            this.lastName = "";
        } else {
            this.firstName = name.substring(0, firstSpace);
            this.lastName = name.substring(firstSpace + 1).trim();
        }
    }

    public int getId() {
        return id;
    }

    public void display() {
        System.out.printf("%-5d%-20s%-15s%-15s%-10s%-15s%-15s\n", 
            id, fullName, firstName, lastName, group, address, phone);
    }
}