package main;

import model.Contact;
import controller.ContactManager;
import view.Menu;
import common.Validation;

public class Main {
    public static void main(String[] args) {
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
                    String phone;
                    
                    while (true) {                        
                        phone = Validation.getPhone("Enter Phone: ", "Invalid phone format.");
                           if (manager.isPhoneExisted(phone)) {
                               System.out.println("Phone number already exits! Pleas enter a diffirent one.");
                        } else {
                               break;
                           }
                    }
                    
                    Contact newContact = new Contact(name, group, address, phone);
                    if (manager.addContact( newContact)) {
                        System.out.println("Successful");
                    }
                    break;
                    
                case 2: 
                    manager.displayAll();
                    break;
                    
                case 3: 
                    System.out.println("------- Delete a Contact -------");
                    int id = Validation.getInt("Enter ID: ", "ID is digit");
                    
                    if (manager.deleteById(id)) {
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