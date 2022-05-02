package main.service;

import main.dto.ResumeCreateDto;
import main.mapper.GsonPrintMapper;
import main.model.MapSection;
import main.model.Resume;
import main.model.section.Contact;
import main.model.section.Section;
import main.model.section.experience.*;
import main.model.type.ContactType;
import main.model.type.SectionType;
import main.repository.abstractClass.Storage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ResumeServiceImpl implements ResumeService {

    private final Storage storage;
    private Set<Link> storageLink = new HashSet<>();

    public ResumeServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void clear() {
        storageLink.clear();
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
    public Set<Link> getStorageLink() {
        return storageLink;
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
        SectionEducation sectionEducation = (SectionEducation) uniqueSectionLink(section.getSection(SectionType.EDUCATION)) ;
        if (sectionEducation != null) {
            List<Experience> experienceEducations = uniqueStorageLink( sectionEducation.getExperienceEducations());
            sectionEducation.setExperienceEducations(experienceEducations);
            section.put(SectionType.EDUCATION, sectionEducation);
        }

        SectionWork sectionWork = (SectionWork) uniqueSectionLink(section.getSection(SectionType.EXPERIENCE)) ;
        if (sectionWork != null) {
            List<ExperienceWork> experiences = uniqueStorageLink( sectionWork.getExperienceWorks());
            sectionWork.setExperienceWorks(experiences);
            section.put(SectionType.EXPERIENCE, sectionWork);
        }
        resume.setSection(section);
        return resume;
    }

    private <T extends Experience> List<T> uniqueStorageLink(List<T> listLinks){
        storageLink.forEach(link -> {
            listLinks.forEach(experience -> {
                if (link.equals(experience.getLink())) {
                    experience.setLink(link);
                }
            });
        });
        listLinks.forEach(experience -> storageLink.add(experience.getLink()));
        return listLinks;
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
            section = uniqueSectionLink(section);
        }
        resume.addSection(sectionType, section);
        storage.update(resume);
    }

    private Section uniqueSectionLink(Section section) {
        if (section instanceof SectionEducation) {
            List<Experience> experiences = ((SectionEducation) section).getExperienceEducations();
            ((SectionEducation) section).setExperienceEducations(uniqueLink(experiences));
        }
        if (section instanceof SectionWork) {
            List<ExperienceWork> experiences = ((SectionWork) section).getExperienceWorks();
            ((SectionWork) section).setExperienceWorks(uniqueLink(experiences));
        }
        return section;
    }

    private <T extends Experience> List<T> uniqueLink(List<T> listLink){
        for (int i = 0; i < listLink.size(); i++) {
            for (int j = i + 1; j < listLink.size(); j++) {
                if (listLink.get(i).getLink().equals(listLink.get(j).getLink())) {
                    listLink.get(j).setLink(listLink.get(i).getLink());
                }
            }
        }
        return listLink;
    }
}
