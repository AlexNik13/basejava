package main.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume>, Print {

    private String uuid;
    private String fullName;

    private Map<ContactType, Print> contacts = new HashMap<>();
    private Map<SectionType, Print> sections = new HashMap<>();


    public Resume() {
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public void addContact(ContactType contactType, Print contact) {
        contacts.put(contactType, contact);
    }

    public void addSection(SectionType sectionType, Print section) {
        sections.put(sectionType, section);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Map<ContactType, Print> getContact() {
        return contacts;
    }

    public void setContact(Map<ContactType, Print> contact) {
        this.contacts = contact;
    }

    public Map<SectionType, Print> getSection() {
        return sections;
    }

    public void setSection(Map<SectionType, Print> section) {
        this.sections = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public int compareTo(Resume resume) {
        if (resume.toString().equals(uuid)) return 0;
        int comp = resume.toString().compareTo(uuid);
        return comp > 0 ? -1 : 1;
    }

    @Override
    public void print() {
        contacts.forEach((contactType, print) -> {
            System.out.print(contactType.getTitle() + ": \t");
            print.print();
        });

        sections.forEach((sectionType, print) -> {
            System.out.println(sectionType.getTitle());
            print.print();
        });
    }
}
