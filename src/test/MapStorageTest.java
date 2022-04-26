package test;

import main.exception.NotExistStorageException;
import main.model.Resume;
import main.repository.MapStorage;
import org.junit.Before;
import org.junit.Test;
import test.manual.ResumeTestData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MapStorageTest {

    private MapStorage storage = new MapStorage();

    private final String UUID_1 = "uuid1";
    private final String UUID_2 = "uuid2";
    private final String UUID_3 = "uuid3";

    private final ResumeTestData resumeTestData_1 = new ResumeTestData(UUID_1, "Alex");
    private final ResumeTestData resumeTestData_2 = new ResumeTestData(UUID_2, "Max");
    private final ResumeTestData resumeTestData_3 = new ResumeTestData(UUID_3, "Alexsandr");

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resumeTestData_1.getResume());
        storage.save(resumeTestData_2.getResume());
        storage.save(resumeTestData_3.getResume());
    }

    @Test
    public void size() {
        int result = storage.size();
        assertEquals(3, result);
    }

    @Test
    public void clear() {
        storage.clear();
        int result = storage.size();
        assertEquals(0, result);
    }

    @Test
    public void getAll() {
        List<Resume> resumes = storage.getAll();
        assertEquals(3, resumes.size());
    }

    @Test
    public void update() {
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
    public void save() {
        storage.save(new Resume("new"));
        int result = storage.size();
        assertEquals(4, result);
    }

    @Test
    public void delete() {
        assertThrows(NotExistStorageException.class, () -> {
            storage.delete("Not exist");
        });

        storage.delete(UUID_1);
        int result = storage.size();
        assertEquals(2, result);
    }

    @Test
    public void get() {
        assertThrows(NotExistStorageException.class, () -> {
            storage.get("Not exist");
        });
        Resume resume = storage.get(UUID_3);
        assertEquals(UUID_3, resume.getUuid());
    }

    @Test
    public void getIndex() {
        Method method;
        String searchKey = null;
        Class[] arg = new Class[1];
        arg[0] = String.class;
        try {
            method = storage.getClass().getDeclaredMethod("getSearchKey", arg);
            method.setAccessible(true);
            searchKey = (String) method.invoke(storage, UUID_1);
            method.setAccessible(false);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        assertEquals(UUID_1, searchKey);
    }
}