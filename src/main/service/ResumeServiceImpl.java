package main.service;

import main.dto.ResumeCreateDto;
import main.mapper.GsonPrintMapper;
import main.model.Resume;
import main.model.section.Contact;
import main.model.section.Section;
import main.model.section.experience.Experience;
import main.model.section.experience.ExperienceWork;
import main.model.section.experience.SectionEducation;
import main.model.section.experience.SectionWork;
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
    public void update(Resume resume) {
        storage.update(resume);
    }

    @Override
    public void save(Resume resume) {
        storage.save(resume);
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
        if (sectionType == SectionType.EDUCATION || sectionType == SectionType.EXPERIENCE) {
            section = uniqueLink(section);
        }
        resume.addSection(sectionType, section);
        storage.update(resume);
    }

    private Section uniqueLink(Section section) {
        if (section instanceof SectionEducation) {
            List<Experience> experiences = ((SectionEducation) section).getExperienceEducations();
            System.out.println("Experience");
            for (int i = 0; i < experiences.size(); i++) {
                for (int j = i + 1; j < experiences.size(); j++) {
                    if (experiences.get(i).getLink().equals(experiences.get(j).getLink())) {
                        experiences.get(j).setLink(experiences.get(i).getLink());
                    }
                }
            }
            ((SectionEducation) section).setExperienceEducations(experiences);
        }
        if (section instanceof SectionWork) {
            List<ExperienceWork> experiences = ((SectionWork) section).getExperienceWorks();
            for (int i = 0; i < experiences.size(); i++) {
                for (int j = i + 1; j < experiences.size(); j++) {
                    if (experiences.get(i).getLink().equals(experiences.get(j).getLink())) {
                        experiences.get(j).setLink(experiences.get(i).getLink());
                    }
                }
            }
            ((SectionWork) section).setExperienceWorks(experiences);
        }
        return section;
    }
}
