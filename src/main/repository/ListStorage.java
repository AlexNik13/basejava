package main.repository;

import main.exception.ExistStorageException;
import main.exception.NotExistStorageException;
import main.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage implements Storage {

    private List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        storage.set(index, resume);
    }

    @Override
    public void save(Resume resume) {
        if(isExist(resume)){
            throw new ExistStorageException(resume.getUuid());
        }
        storage.add(resume);
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        return storage.get(index);
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        storage.remove(index);
    }

    @Override
    public List<Resume> getAll() {
        return storage;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public boolean isExist(Resume resume) {
        return storage.contains(resume);
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        throw new NotExistStorageException(uuid);
    }
}
