package main.repository;


import main.exception.ExistStorageException;
import main.exception.NotExistStorageException;
import main.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapIntegerKeyStorage implements Storage {

    private Map<Integer, Resume> storage = new HashMap<>();
    private Integer size = 0;

    @Override
    public void clear() {
        storage.clear();
        size = 0;
    }

    @Override
    public void update(Resume resume) {
        if (!isExist(resume)) {
            throw new NotExistStorageException(resume.getUuid());
        }
        storage.put(getKey(resume), resume);
    }

    @Override
    public void save(Resume resume) {
        if (isExist(resume)) {
            throw new ExistStorageException(resume.getUuid());
        }
        storage.put(size, resume);
        size++;
    }

    @Override
    public Resume get(String uuid) {
        Resume resume = new Resume(uuid);
        if (!isExist(resume)) {
            throw new NotExistStorageException(uuid);
        }
        return storage.get(getKey(resume));
    }

    @Override
    public void delete(String uuid) {
        Resume resume = new Resume(uuid);
        if (!isExist(resume)) {
            throw new NotExistStorageException(resume.getUuid());
        }
        storage.remove(getKey(resume));
        size--;
    }

    @Override
    public List<Resume> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isExist(Resume resume) {
        return storage.containsValue(resume);
    }

    private Integer getKey(Resume resume) {
        for (Integer i = 0; i < size; i++) {
            if (storage.get(i).equals(resume)) {
                return i;
            }
        }
        throw new NotExistStorageException(resume.getUuid());
    }
}
