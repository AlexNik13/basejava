package main.service;

import main.dto.ResumeCreateDto;
import main.mapper.GsonPrintMapper;
import main.model.Resume;
import main.model.section.Contact;
import main.model.section.Section;
import main.model.type.ContactType;
import main.model.type.SectionType;
import main.repository.abstractClass.Storage;
import main.repository.link.NameLinkRepository;

import java.util.List;
import java.util.UUID;

public class ResumeServiceImpl implements ResumeService {

    private final Storage storage;
    private final NameLinkRepository nameLinkRepository;

    public ResumeServiceImpl(Storage storage, NameLinkRepository nameLinkRepository) {
        this.storage = storage;
        this.nameLinkRepository = nameLinkRepository;
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
    public void deleteResume(String  uuid) {
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
    public void addContact(String  uuid, ContactType contactType, String contact) {
        Resume resume = storage.get(uuid);
        resume.addSection(contactType, new Contact(contactType.getTitle(), contact));
        storage.update(resume);
    }

    @Override
    public void addSection(String  uuid, SectionType sectionType, Section section) {
        Resume resume = storage.get(uuid);
        resume.addSection(sectionType, section);
        storage.update(resume);
    }
}
