package main.service;

import main.dto.ResumeCreateDto;
import main.model.Resume;
import main.model.section.Section;
import main.model.section.experience.Link;
import main.model.type.ContactType;
import main.model.type.SectionType;

import java.util.List;
import java.util.Set;

public interface ResumeService {
    void createResume(ResumeCreateDto dto);

    List<Resume> getAllResume();

    Resume getResumeByUuid(String uuid);

    void deleteResume(Resume resume);

    void printAll();

    void printByUuid(String uuid);

    void update(Resume resume);

    void save(Resume resume);

    void addContact(String uuid, ContactType contactType, String contact);

    void addSection(String uuid, SectionType sectionType, Section section);

    Set<Link> getStorageLink();
}
