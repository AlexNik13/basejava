package main.model;

import main.model.section.Section;

public class Contact implements Section {

    private String contactType;
    private String contact;

    public Contact(String contactType, String contact) {
        this.contactType = contactType;
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
