package main.service;

import main.dto.ResumeCreateDto;
import main.mapper.GsonPrintMapper;
import main.model.MapSection;
import main.model.Resume;
import main.model.section.Contact;
import main.model.section.Section;
import main.model.section.experience.Experience;
import main.model.section.experience.Organization;
import main.model.section.experience.SectionEducation;
import main.model.section.experience.SectionWork;
import main.model.type.ContactType;
import main.model.type.SectionType;
import main.repository.FileStorage;
import main.repository.ObjectStreamPathStorage;
import main.repository.abstractClass.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ResumeServiceImpl implements ResumeService {

    private Storage storage;
    private List<Organization> storageOrganization = new ArrayList<>();

    public ResumeServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void setStrategy(Storage strategy) {
        if (strategy instanceof ObjectStreamPathStorage || strategy instanceof FileStorage) {
            this.storage = strategy;
        }
    }

    @Override
    public void clear() {
        storageOrganization.clear();
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
    public List<Organization> getStorageOrganization() {
        return storageOrganization;
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
    public void deleteResume(String uuid) {
        storage.delete(uuid);
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
    public void update(Resume resume) {
        storage.update(uniqueStorageLink(resume));
    }

    @Override
    public void save(Resume resume) {
        storage.save(uniqueStorageLink(resume));
    }

    private Resume uniqueStorageLink(Resume resume) {
        MapSection<SectionType, Section> section = resume.getSection();
        SectionEducation sectionEducation = (SectionEducation) section.getSection(SectionType.EDUCATION);
        if (sectionEducation != null) {
            uniqueStorageLink(sectionEducation.getExperienceEducations());
            section.put(SectionType.EDUCATION, sectionEducation);
        }
        SectionWork sectionWork = (SectionWork) section.getSection(SectionType.EXPERIENCE);
        if (sectionWork != null) {
            uniqueStorageLink(sectionWork.getExperienceWorks());
            section.put(SectionType.EXPERIENCE, sectionWork);
        }
        resume.setSection(section);
        return resume;
    }

    private <T extends Experience> void uniqueStorageLink(List<T> organizations) {
        organizations.forEach(organization -> {
            if (storageOrganization.contains(organization.getLink())) {
                organization.setLink(storageOrganization.get(storageOrganization.indexOf(organization.getLink())));
            } else {
                storageOrganization.add(organization.getLink());
            }
        });
    }

    @Override
    public void addContact(String uuid, ContactType contactType, String contact) {
        Resume resume = storage.get(uuid);
        resume.addSection(contactType, new Contact(contactType.getTitle(), contact));
        storage.update(resume);
    }

    @Override
    public void addSection(String uuid, SectionType sectionType, Section section) {
        Resume resume = storage.get(uuid);
        resume.addSection(sectionType, section);
        storage.update(resume);
    }
}
