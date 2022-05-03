package main.pattern;

import main.dto.ResumeCreateDto;
import main.model.Resume;
import main.model.section.Section;
import main.model.section.experience.Organization;
import main.model.type.ContactType;
import main.model.type.SectionType;
import main.repository.FileStorage;
import main.repository.ObjectStreamPathStorage;
import main.service.ResumeService;
import main.service.ResumeServiceImpl;

import java.io.File;
import java.util.List;
import java.util.Map;

public class DecoratorImpl implements Decorator {

    private ResumeService resumeService;
    private final String FILE = "/home/user/UAPP/3/basejava/storageFile";
    private final String PATH = "/home/user/UAPP/3/basejava/storagePath";

    public DecoratorImpl() {
        useFile();
    }

    @Override
    public void useFile() {
        resumeService = new ResumeServiceImpl(new FileStorage(new File(FILE)));
    }

    @Override
    public void usePath() {
        resumeService = new ResumeServiceImpl(new ObjectStreamPathStorage(PATH));
    }

    @Override
    public void clear() {
        resumeService.clear();
    }

    @Override
    public void createResume(ResumeCreateDto dto) {
        resumeService.createResume(dto);
    }

    @Override
    public List<Resume> getAllResume() {
        return resumeService.getAllResume();
    }

    @Override
    public Resume getResumeByUuid(String uuid) {
        return resumeService.getResumeByUuid(uuid);
    }

    @Override
    public void deleteResume(String uuid) {
        resumeService.deleteResume(uuid);
    }

    @Override
    public void printAll() {
        resumeService.printAll();
    }

    @Override
    public void printByUuid(String uuid) {
        resumeService.printByUuid(uuid);
    }

    @Override
    public void update(Resume resume) {
        resumeService.update(resume);
    }

    @Override
    public void save(Resume resume) {
        resumeService.save(resume);
    }

    @Override
    public void addContact(String uuid, ContactType contactType, String contact) {
        resumeService.addContact(uuid, contactType, contact);
    }

    @Override
    public void addSection(String uuid, SectionType sectionType, Section section) {
        resumeService.addSection(uuid, sectionType, section);
    }

    @Override
    public Map<Integer, Organization> getStorageOrganization() {
        return resumeService.getStorageOrganization();
    }
}
