package test;

import main.exception.NotExistStorageException;
import main.model.Resume;
import main.repository.FileStorage;
import main.repository.abstractClass.Storage;
import org.junit.Before;
import org.junit.Test;
import test.manual.ResumeFull;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileStorageTest {

    private File file = new File("/home/user/UAPP/3/basejava/storage/");

    private Storage storage = new FileStorage(file);

    private final String UUID_1 = "uuid1";
    private final String UUID_2 = "uuid2";
    private final String UUID_3 = "uuid3";

    private final ResumeFull resumeFull_1 = new ResumeFull(UUID_1, "Alex");
    private final ResumeFull resumeFull_2 = new ResumeFull(UUID_2, "Max");
    private final ResumeFull resumeFull_3 = new ResumeFull(UUID_3, "Alexsandr");

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resumeFull_1.getResume());
        storage.save(resumeFull_2.getResume());
        storage.save(resumeFull_3.getResume());
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