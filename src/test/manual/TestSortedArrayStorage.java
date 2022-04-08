package test.manual;

import main.model.Resume;
import main.repository.base.AbstractArrayStorage;
import main.repository.SortedArrayStorage;

import java.util.Random;

public class TestSortedArrayStorage {

    static final AbstractArrayStorage STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {

        Random rnd = new Random();

        for (int i = 0; i < 100; i++) {
            Resume resume = new Resume();
            resume.setUuid("qwe" + rnd.nextInt(50));
            STORAGE.save(resume);
        }

        Resume[] resumes = STORAGE.getAll();

        for (Resume resume : resumes) {
            System.out.println(resume.toString());
        }

        Resume resume = new Resume();
        resume.setUuid("123");
        String strSize = "size= ";

        System.out.println(strSize + STORAGE.size());

        STORAGE.save(resume);
        STORAGE.save(resume);
        System.out.println(strSize + STORAGE.size());

        STORAGE.delete(resume.getUuid());
        System.out.println(strSize + STORAGE.size());
    }
}
