/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        storage = new Resume[10000];
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume == null) return null;
            if (resume.uuid.equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        Resume resume = get(uuid);
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
    Resume[] getAll() {
        int size = size();
        Resume[] newStorage = new Resume[size];
        for (int i = 0; i < size; i++) {
            newStorage[i] = storage[i];
        }
        return newStorage;
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (resume == null) break;
            size++;
        }
        return size;
    }
}
