package main.repository;

import main.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            size++;
            add(resume, Math.abs(index + 1));
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