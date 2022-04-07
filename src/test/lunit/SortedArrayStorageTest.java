package test.lunit;

import main.model.Resume;
import main.repository.SortedArrayStorage;
import main.repository.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedArrayStorageTest {

    private Storage storage;

    private final String UUID_1 = "uuid1";
    private final String UUID_2 = "uuid2";
    private final String UUID_3 = "uuid3";

    @BeforeEach
    void setUp() {
        storage = new SortedArrayStorage();
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        Resume r = new Resume(UUID_3);
        storage.save(r);
    }

    @Test
    void saveUnique() {
        assertEquals(3, storage.size());
    }

    @Test
    void saveNotUnique() {
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
        assertEquals(3, storage.size());
    }
}