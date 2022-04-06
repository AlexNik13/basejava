package main.repository;

import main.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage {
    Resume[] storage = new Resume[10000];

    public void clear() {
        storage = new Resume[10000];
    }

    public void save(Resume r) {
        if (get(r.getUuid()) != null || size() >= storage.length) return;
        storage[size()] = r;
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
        Resume resume = get(uuid);
        if (resume == null) return;
        int step = 0;
        if (resume != null) {
            for (int i = 0; i < size(); i++) {
                if (storage[i].equals(resume)) {
                    step++;
                }
                storage[i] = storage[i + step];
            }
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
        return newStorage;
    }

    public int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (resume == null) break;
            size++;
        }
        return size;
    }
}
