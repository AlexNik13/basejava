package main.model;

public class Contact implements Print {
    private String contactName;

    public Contact(String contactName) {
        this.contactName = contactName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Override
    public void print() {
        System.out.println(contactName);
    }
}
