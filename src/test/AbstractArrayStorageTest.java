package test;

import main.model.Resume;
import main.repository.SortedArrayStorage;
import main.repository.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractArrayStorageTest {

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
    void save() {
        storage.save(new Resume("new"));
        storage.save(new Resume(UUID_3));
        int result = storage.size();
        assertEquals(4, result);
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
    void get() {
        Resume resume = storage.get(UUID_3);
        assertEquals(UUID_3, resume.getUuid());
    }

    @Test
    void getIndex() {
        Method method;
        int index = -1;
        Class[] arg = new Class[1];
        arg[0] = String.class;

        try {
            method = storage.getClass().getDeclaredMethod("getIndex", arg);
            method.setAccessible(true);
            index = (int) method.invoke(storage, UUID_1);
            method.setAccessible(false);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        assertEquals(0, index);
    }
}