package main;

import java.util.ArrayList;
import java.util.List;
import model.Contact;
import controller.ContactManager;
import view.Menu;
import common.Validation;

public class Main {
    public static void main(String[] args) {
        List<Contact> contactList = new ArrayList<>();
        ContactManager manager = new ContactManager();

        while (true) {
            Menu.display();
            int choice = Validation.getInt("Please choice one option: Your choice: ", "Choice must be a digit.");

            switch (choice) {
                case 1: 
                    System.out.println("-------- Add a Contact --------");
                    String name = Validation.getString("Enter Name: ", "Name is required.");
                    String group = Validation.getString("Enter Group: ", "Group is required.");
                    String address = Validation.getString("Enter Address: ", "Address is required.");
                    String phone = Validation.getPhone("Enter Phone: ", "Invalid phone format.");
                    
                    Contact newContact = new Contact(name, group, address, phone);
                    if (manager.addContact(contactList, newContact)) {
                        System.out.println("Successful");
                    }
                    break;
                    
                case 2: 
                    manager.displayAll(contactList);
                    break;
                    
                case 3: 
                    System.out.println("------- Delete a Contact -------");
                    int id = Validation.getInt("Enter ID: ", "ID is digit");
                    Contact contactToDelete = manager.getContactById(contactList, id);
                    
                    if (contactToDelete != null) {
                        manager.deleteContact(contactList, contactToDelete);
                        System.out.println("Successful");
                    } else {
                        System.out.println("No found contact");
                    }
                    break;
                    
                case 4: 
                    return;
                    
                default:
                    System.out.println("Please choose from 1 to 4.");
            }
        }
    }
}