package main.service;

import main.dto.ResumeCreateDto;
import main.model.Resume;
import main.repository.ListStorage;

import java.util.List;
import java.util.UUID;

public class ResumeServiceImpl implements ResumeService {

    private final ListStorage storage;

    public ResumeServiceImpl(ListStorage storage) {
        this.storage = storage;
    }

    @Override
    public void createResume(ResumeCreateDto dto){
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
}
