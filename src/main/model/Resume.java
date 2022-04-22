package main.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    private String uuid;
    private String fullName;

    private Map<ContactType, Print> contacts = new HashMap<>();
    private Map<SectionType, List<Print>> sections = new HashMap<>();


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

    public void addSection(SectionType sectionType, List<Print> section) {
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

    public Map<ContactType, Print> getContacts() {
        return contacts;
    }

    public void setContacts(Map<ContactType, Print> contacts) {
        this.contacts = contacts;
    }

    public Map<SectionType, List<Print>> getSections() {
        return sections;
    }

    public void setSections(Map<SectionType, List<Print>> sections) {
        this.sections = sections;
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
}
