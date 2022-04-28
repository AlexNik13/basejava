package test;

import main.exception.NotExistStorageException;
import main.model.Resume;
import main.repository.FileStorage;
import main.repository.ObjectStreamPathStorage;
import main.repository.abstractClass.Storage;
import org.junit.Before;
import org.junit.Test;
import test.manual.ResumeTestData;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AbstractPathStorageTest {
    private String file = "/home/user/UAPP/3/basejava/storage";

    private Storage storage = new ObjectStreamPathStorage(file);

    private final String UUID_1 = "uuid1";
    private final String UUID_2 = "uuid2";
    private final String UUID_3 = "uuid3";

    private Resume resume1 = ResumeTestData.getResume(UUID_1, "Alex");
    private Resume resume2 = ResumeTestData.getResume(UUID_2, "Max");
    private Resume resume3 = ResumeTestData.getResume(UUID_3, "Alexsandr");

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void save() {
        storage.save(new Resume("new"));
        int result = storage.size();
        assertEquals(4, result);
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
}