package main.repository.abstractClass;

import main.model.Resume;

import java.util.List;

public interface Storage {

    void clear();

    void update(Resume resume);

    void save(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    List<Resume> getAll();

    int size();

    default List<Resume> getAllSorted() {
        List<Resume> sortResume = getAll();
        sortResume.sort((o1, o2) -> {
            if (o1.getFullName().equals(o2.getFullName())) {
                return o1.compareTo(o2);
            }
            return o1.getFullName().compareTo(o2.getFullName());
        });
        return sortResume;
    }
}
