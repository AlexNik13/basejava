package main.model.section;

public class Contact implements Section {

    private String contactType;
    private String contact;

    public Contact(String contactType, String contact) {
        this.contactType = contactType;
        this.contact = contact;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
