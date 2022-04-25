package main.model;

import main.model.section.Section;
import main.model.type.ContactType;
import main.model.type.SectionType;

import java.io.Serializable;
import java.util.Objects;

public class Resume implements Comparable<Resume>, Serializable {

    private String uuid;
    private String fullName;

    private MapSection<ContactType, Section> contact = new MapSection(ContactType.class);
    private MapSection<SectionType, Section> section = new MapSection(SectionType.class);

    public Resume() {
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public void removeSection(Enum<?> enumType) {
        if (enumType instanceof ContactType) {
            this.contact.remove((ContactType) enumType);
        } else {
            this.section.remove((SectionType) enumType);
        }
    }

    public void addSection(Enum<?> enumType, Section section) {
        if (enumType instanceof ContactType) {
            this.contact.put((ContactType) enumType, section);
        } else {
            this.section.put((SectionType) enumType, section);
        }
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public MapSection<ContactType, Section> getContact() {
        return this.contact;
    }

    public void setContact(MapSection<ContactType, Section> contact) {
        this.contact = contact;
    }

    public MapSection<SectionType, Section> getSection() {
        return this.section;
    }

    public void setSection(MapSection<SectionType, Section> section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(this.uuid, resume.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.uuid);
    }

    @Override
    public String toString() {
        return this.uuid;
    }

    @Override
    public int compareTo(Resume resume) {
        if (resume.toString().equals(this.uuid)) return 0;
        int comp = resume.toString().compareTo(this.uuid);
        return comp > 0 ? -1 : 1;
    }
}
