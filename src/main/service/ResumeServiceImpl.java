package main.service;

import main.dto.EducationPlaceRequestDto;
import main.dto.ResumeCreateDto;
import main.dto.WorkPlaceRequestDto;
import main.mapper.GsonPrintMapper;
import main.model.MapSection;
import main.model.Resume;
import main.model.experience.SectionEducation;
import main.model.experience.SectionWork;
import main.model.section.Contact;
import main.model.section.Section;
import main.model.type.ContactType;
import main.model.type.SectionType;
import main.repository.abstractClass.Storage;

import java.util.List;
import java.util.UUID;

public class ResumeServiceImpl implements ResumeService {

    private final Storage storage;

    public ResumeServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void createResume(ResumeCreateDto dto) {
        Resume resume = new Resume();
        resume.setUuid(UUID.randomUUID().toString());
        resume.setFullName(dto.getFullName());
        resume.setContact(dto.getContact());
        resume.setSection(dto.getSection());
        storage.save(resume);
    }

    @Override
    public List<Resume> getAllResume() {
        return storage.getAll();
    }

    @Override
    public Resume getResumeByUuid(String uuid) {
        return storage.get(uuid);
    }

    @Override
    public void deleteResume(Resume resume) {
        storage.delete(resume.getUuid());
    }

    @Override
    public void printAll() {
        System.out.println(GsonPrintMapper.toGson(this.getAllResume()));
    }

    @Override
    public void printByUuid(String uuid) {
        System.out.println(GsonPrintMapper.toGson(this.getResumeByUuid(uuid)));
    }

    @Override
    public void addPlaceEducation(String uuid, EducationPlaceRequestDto dto) {
        Resume resume = getResumeByUuid(uuid);
        MapSection<SectionType, Section> sections = resume.getSection();
        SectionEducation education = (SectionEducation) sections.getSection(SectionType.EDUCATION);

        if (education == null) {
            education = new SectionEducation();
        }

        education.addEducationExperience(dto.getStartDate(),
                dto.getFinishDate(),
                dto.getTitle(),
                dto.getLink(),
                dto.getDescription());

        sections.put(SectionType.EDUCATION, education);
        resume.setSection(sections);
        storage.update(resume);
    }

    @Override
    public void update(Resume resume) {
        storage.update(resume);
    }

    @Override
    public void addPlaceWork(String uuid, WorkPlaceRequestDto dto) {

        Resume resume = getResumeByUuid(uuid);
        MapSection<SectionType, Section> sections = resume.getSection();
        SectionWork works = (SectionWork) sections.getSection(SectionType.EXPERIENCE);

        if (works == null) {
            works = new SectionWork();
        }

        works.addWorkExperience(dto.getStartDate(),
                dto.getFinishDate(),
                dto.getTitle(),
                dto.getLink(),
                dto.getDescription(),
                dto.getDetail());

        sections.put(SectionType.EXPERIENCE, works);
        resume.setSection(sections);
        storage.update(resume);
    }

    @Override
    public void save(Resume resume) {
        storage.save(resume);
    }

    @Override
    public void addContact(Resume resume, ContactType contactType, String contact) {
        Resume r = storage.get(resume.getUuid());
        r.addSection(contactType, new Contact(contactType.getTitle(), contact));
        storage.update(r);
    }

    @Override
    public void addSection(Resume resume, SectionType sectionType, Section section) {
        Resume r = storage.get(resume.getUuid());
        r.addSection(sectionType, section);
        storage.update(r);
    }
}
