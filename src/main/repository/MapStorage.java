package main.repository;

import main.exception.ExistStorageException;
import main.exception.NotExistStorageException;
import main.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage implements Storage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void update(Resume resume) {
        if (!storage.containsKey(resume.getUuid())) {
            throw new NotExistStorageException(resume.getUuid());
        }
        storage.put(resume.getUuid(), resume);
    }

    @Override
    public void save(Resume resume) {
        if (storage.containsKey(resume.getUuid())) {
            throw new ExistStorageException(resume.getUuid());
        }
        storage.put(resume.getUuid(), resume);
    }

    @Override
    public Resume get(String uuid) {
        if (!storage.containsKey(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        return storage.get(uuid);
    }

    @Override
    public void delete(String uuid) {
        if (!storage.containsKey(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        storage.remove(uuid);
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = storage.values().toArray(Resume[]::new);
        return resumes;
    }

    @Override
    public int size() {
        return storage.size();
    }
}
