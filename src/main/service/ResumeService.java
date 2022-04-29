package main.service;

import main.dto.EducationPlaceRequestDto;
import main.dto.ResumeCreateDto;
import main.dto.WorkPlaceRequestDto;
import main.model.Resume;
import main.model.section.Section;
import main.model.type.ContactType;
import main.model.type.SectionType;

import java.util.List;

public interface ResumeService {
    void createResume(ResumeCreateDto dto);

    List<Resume> getAllResume();

    Resume getResumeByUuid(String uuid);

    void deleteResume(String  uuid);

    void printAll();

    void printByUuid(String uuid);

    void addContact(String uuid, ContactType contactType, String contact);

    void addSection(String uuid, SectionType sectionType, Section section);
}
