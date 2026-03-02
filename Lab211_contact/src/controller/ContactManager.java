package controller;

import java.util.List;
import model.Contact;

public class ContactManager {

    public boolean addContact(List<Contact> list, Contact contact) {
        return list.add(contact);
    }

    public void displayAll(List<Contact> list) {
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        System.out.printf("%-5s%-20s%-15s%-15s%-10s%-15s%-15s\n", 
            "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        for (Contact contact : list) {
            contact.display();
        }
    }

    public boolean deleteContact(List<Contact> list, Contact contact) {
        return list.remove(contact);
    }

    public Contact getContactById(List<Contact> list, int id) {
        for (Contact c : list) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}