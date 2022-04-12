package main.repository;

import main.exception.ExistStorageException;
import main.exception.NotExistStorageException;
import main.exception.StorageException;
import main.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 1000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            storage[index] = resume;
        }
    }

    @Override
    public void save(Resume resume) {
        if(isExist(resume)){
            throw new ExistStorageException(resume.getUuid());
        }
        if (size() >= STORAGE_LIMIT) {
            throw new StorageException("Storage is full, " + resume.getUuid() + " not added.");
        }
        storage[size] = resume;
        size++;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
            size--;
        }
    }

    @Override
    public List<Resume> getAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public boolean isExist(Resume resume){
        for (Resume r : storage) {
         if(r.equals(resume)) return true;
        }
        return false;
    }

    protected abstract int getIndex(String uuid);
}
