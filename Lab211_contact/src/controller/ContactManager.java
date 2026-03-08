package controller;

import java.util.ArrayList;
import java.util.List;
import model.Contact;

public class ContactManager {
    // dữ liệu được đóng gói trong lớp managermant
    private final List<Contact> contacts;
    
    public ContactManager() {
        this.contacts = new ArrayList<>();
    }
    
    public boolean isPhoneExisted(String phone) {
        for (Contact c : contacts) {
            if (c.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public boolean addContact(Contact contact) {
        if (contact == null ) 
            return false;
        return contacts.add(contact); // Sửa từ list thành contacts
    }

    public void displayAll() {
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        System.out.printf("%-5s%-20s%-15s%-15s%-10s%-15s%-15s\n", 
            "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        for (Contact contact : contacts) {
            contact.display();
        }
    }

    public boolean deleteById(int id) {
       Contact c = getContactById(id);
        if (c == null) return false;
        return contacts.remove(c); // Phải có dòng remove này mới xóa được
    }
// BỎ tham số List<Contact> list ở đây
    public Contact getContactById( int id) {
        for (Contact c : contacts) { // Sửa từ list thành contacts
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }


}