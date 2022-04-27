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

    void deleteResume(Resume resume);

    void printAll();

    void printByUuid(String uuid);

    void addPlaceEducation(String uuid, EducationPlaceRequestDto dto);

    void update(Resume resume);

    void addPlaceWork(String uuid, WorkPlaceRequestDto dto);

    void save(Resume resume);

    void addContact(Resume resume, ContactType contactType, String contact);

    void addSection(Resume resume, SectionType sectionType, Section section);
}
