package main.repository;

import main.model.Resume;
import main.repository.abstractClass.AbstractStorage;

import java.util.HashMap;
import java.util.Map;

public class MapHashStorage extends AbstractStorage {

    private Map<Integer, Resume> storage = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        for (Map.Entry<Integer, Resume> resume : storage.entrySet()) {
            if (resume.getValue().getUuid().equals(uuid)) {
                return resume.getKey();
            }
        }
        return null;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage.put((Integer) searchKey, r);
    }

    @Override
    protected boolean isExist(Object searchKey) {

        return storage.get((Integer) searchKey) != null;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        storage.put(r.hashCode(), r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get((Integer) searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove((Integer) searchKey);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(Resume[]::new);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
