package test.lunit;


import main.model.Resume;
import main.repository.ArrayStorage;
import main.repository.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ArrayStorageTest {

    private Storage storage;

    private final String UUID_1 = "uuid1";
    private final String UUID_2 = "uuid2";
    private final String UUID_3 = "uuid3";

    @BeforeEach
    void setUp() {
        storage = new ArrayStorage();
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        Resume r = new Resume(UUID_3);
        storage.save(r);
    }

    @Test
    void clear() {
        storage.clear();
        int result = storage.size();
        assertEquals(0, result);
    }

    @Test
    void update() {
        Resume resume = new Resume(UUID_3);
        Resume resultResume = storage.get(UUID_3);
        assertEquals(resume, resultResume);
    }

    @Test
    void save() {
        storage.save(new Resume("new"));
        int result = storage.size();
        assertEquals(4, result);
    }

    @Test
    void get() {
        Resume resume = storage.get(UUID_3);
        assertEquals(UUID_3, resume.getUuid());
    }

    @Test
    void delete() {
        storage.delete(UUID_1);
        int result = storage.size();
        assertEquals(2, result);
    }

    @Test
    void getAll() {
        Resume[] resumes = storage.getAll();
        assertEquals(3, resumes.length);
    }

    @Test
    void size() {
        int result = storage.size();
        assertEquals(3, result);
    }
}