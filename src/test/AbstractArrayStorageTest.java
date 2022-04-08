package test;

import main.exception.NotExistStorageException;
import main.model.Resume;
import main.repository.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class AbstractArrayStorageTest {

    private Storage storage;

    private final String UUID_1 = "uuid1";
    private final String UUID_2 = "uuid2";
    private final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    @Test
    void save() {
        storage.save(new Resume("new"));
        int result = storage.size();
        assertEquals(4, result);
    }

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
    void delete() {
        Exception exception = assertThrows(NotExistStorageException.class, () -> {
            storage.delete("Not exist");
        });

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
        Exception exception = assertThrows(NotExistStorageException.class, () -> {
            storage.get("Not exist");
        });
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

    @Test
    void update() {
        Exception exception = assertThrows(NotExistStorageException.class, () -> {
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
}