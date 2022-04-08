package main.repository;

import main.exception.ExistStorageException;
import main.exception.StorageException;
import main.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage is full, " + resume.getUuid() + " not added.");
        }
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            size++;
            add(resume, Math.abs(index + 1));
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    private void add(Resume resume, int index) {
        System.arraycopy(storage, index, storage, index + 1, size - index - 1);
        storage[index] = resume;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}