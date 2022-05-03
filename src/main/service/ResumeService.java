package main.service;

import main.dto.ResumeCreateDto;
import main.model.Resume;
import main.model.section.Section;
import main.model.section.experience.Organization;
import main.model.type.ContactType;
import main.model.type.SectionType;

import java.util.List;
import java.util.Map;

public interface ResumeService {
    void clear();

    void createResume(ResumeCreateDto dto);

    List<Resume> getAllResume();

    Resume getResumeByUuid(String uuid);

    void deleteResume(String uuid);

    void printAll();

    void printByUuid(String uuid);

    void update(Resume resume);

    void save(Resume resume);

    void addContact(String uuid, ContactType contactType, String contact);

    void addSection(String uuid, SectionType sectionType, Section section);

    Map<Integer, Organization> getStorageOrganization();
}
