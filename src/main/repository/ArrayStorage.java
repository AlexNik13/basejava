package main.repository;

import main.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    static final int STORAGE_LIMIT = 10;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size >= storage.length) {
            System.out.println("storage is full");
            return;
        }
        storage[size] = r;
        size++;
    }

    public Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume == null) return null;
            if (resume.getUuid().equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
            size--;
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("Resume not exist");
        } else {
            storage[index] = resume;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        int size = size();
        Resume[] newStorage = new Resume[size];
        for (int i = 0; i < size; i++) {
            newStorage[i] = storage[i];
        }
        return Arrays.copyOfRange(storage, 0, size());
    }

    public int size() {
        return size;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
