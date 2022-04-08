package main.repository.list;

import main.exception.NotExistStorageException;
import main.model.Resume;
import main.repository.base.AbstractStorage;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {


    private List<Resume> storage = new ArrayList<>();

    private int size = 0;



   @Override
    public void clear() {
        storage.clear();
        size = 0;
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        storage.set(index, resume);
    }

    @Override
    public void save(Resume resume) {
        storage.add(resume);
        size++;
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
    public Resume[] getAll() {
        return storage.toArray(Resume[]::new);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        throw new NotExistStorageException(uuid);
    }
}
