package main.service;

import main.dto.ResumeCreateDto;
import main.model.Resume;

import java.util.List;

public interface ResumeService {
    void createResume(ResumeCreateDto dto);

    List<Resume> getAllResume();

    Resume getResumeByUuid(String uuid);

    void deleteResume(Resume resume);

    void printAll();

    void printByUuid(String uuid);
}
