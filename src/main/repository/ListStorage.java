package main.repository;

import main.model.Resume;

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

    }

    @Override
    public void save(Resume resume) {
        storage.add(resume);
        size++;
    }

    @Override
    public Resume get(String uuid) {

        return ;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected int getIndex(String uuid) {
        storage.stream()
        return 0;
    }
}
