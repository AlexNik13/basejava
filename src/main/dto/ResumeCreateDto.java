package main.dto;

import main.model.MapSection;
import main.model.section.Section;
import main.model.type.ContactType;
import main.model.type.SectionType;

public class ResumeCreateDto {
    private String fullName;

    private MapSection<ContactType, Section> contact = new MapSection(ContactType.class);
    private MapSection<SectionType, Section> section = new MapSection(SectionType.class);

    public ResumeCreateDto(String fullName, MapSection<ContactType, Section> contact, MapSection<SectionType, Section> section) {
        this.fullName = fullName;
        this.contact = contact;
        this.section = section;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public MapSection<ContactType, Section> getContact() {
        return contact;
    }

    public void setContact(MapSection<ContactType, Section> contact) {
        this.contact = contact;
    }

    public MapSection<SectionType, Section> getSection() {
        return section;
    }

    public void setSection(MapSection<SectionType, Section> section) {
        this.section = section;
    }
}
