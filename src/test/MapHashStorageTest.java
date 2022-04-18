package test;

import main.exception.NotExistStorageException;
import main.model.Resume;
import main.repository.MapHashStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class MapHashStorageTest {

    private MapHashStorage storage = new MapHashStorage();

    private final String UUID_1 = "uuid1";
    private final String UUID_2 = "uuid2";
    private final String UUID_3 = "uuid3";

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    void size() {
        int result = storage.size();
        assertEquals(3, result);
    }

    @Test
    void clear() {
        storage.clear();
        int result = storage.size();
        assertEquals(0, result);
    }

    @Test
    void getAll() {
        Resume[] resumes = storage.getAll();
        assertEquals(3, resumes.length);
    }

    @Test
    void update() {
        assertThrows(NotExistStorageException.class, () -> {
            Resume resume = new Resume("Update");
            storage.update(resume);
        });

        String uuid = "UUID_5";
        Resume resume = new Resume(uuid);
        Resume resume2 = new Resume(uuid);
        storage.save(resume);
        storage.update(resume2);
        Resume resultResume = storage.get(uuid);
        assertNotSame(resume, resultResume);
    }

    @Test
    void save() {
        storage.save(new Resume("new"));
        int result = storage.size();
        assertEquals(4, result);
    }

    @Test
    void delete() {
        assertThrows(NotExistStorageException.class, () -> {
            storage.delete("Not exist");
        });

        storage.delete(UUID_1);
        int result = storage.size();
        assertEquals(2, result);
    }

    @Test
    void get() {
        assertThrows(NotExistStorageException.class, () -> {
            storage.get("Not exist");
        });
        Resume resume = storage.get(UUID_3);
        assertEquals(UUID_3, resume.getUuid());
    }

    @Test
    void getIndex() {
        Method method;
        Integer searchKey = null;
        Class[] arg = new Class[1];
        arg[0] = String.class;
        try {
            method = storage.getClass().getDeclaredMethod("getSearchKey", arg);
            method.setAccessible(true);
            searchKey = (Integer) method.invoke(storage, UUID_1);
            method.setAccessible(false);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        assertEquals(storage.get(UUID_1).hashCode(), searchKey);
    }
}