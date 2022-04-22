package main.model;

import main.mapper.GsonPrintMapper;
import main.model.section.Section;
import main.model.type.ContactType;
import main.model.section.SectionType;

import java.util.*;

public class Resume implements Comparable<Resume> {

    private String uuid;
    private String fullName;

    private Map<ContactType, Section> contacts = new HashMap<>();
    private Map<SectionType, Section> sections = new HashMap<>();

    public Resume() {
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public void printContactOrSection(Enum<?> section){
        Object o = section instanceof ContactType ? contacts.get((ContactType)section) : this.sections.get((SectionType)section);
        System.out.println(GsonPrintMapper.toGson(o));
    }

    public void printResume(){
        System.out.println(GsonPrintMapper.toGson(this));
    }

    public void addContact(ContactType contactType, Section contact) {
        contacts.put(contactType, contact);
    }

    public void addSection(SectionType sectionType, Section section) {
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

    public Map<ContactType, Section> getContacts() {
        return contacts;
    }

    public void setContacts(Map<ContactType, Section> contacts) {
        this.contacts = contacts;
    }

    public Map<SectionType, Section> getSections() {
        return sections;
    }

    public void setSections(Map<SectionType, Section> sections) {
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
