package test;

import main.repository.ArrayStorage;
import main.model.Resume;

import java.util.Random;

/**
 * Test for your main.repository.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();
    static final String uuid1 = "uuid1";
    static final String uuid2 = "uuid2";
    static final String uuid3 = "uuid3";
    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid(uuid1);
        Resume r2 = new Resume();
        r2.setUuid(uuid2);
        Resume r3 = new Resume();
        r3.setUuid(uuid3);

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        Resume resume = new Resume(uuid1);

        System.out.println("\nNo update : "  + (resume == ARRAY_STORAGE.get(uuid1)));
        ARRAY_STORAGE.update(resume);
        System.out.println("\nAfter update : "  + (resume == ARRAY_STORAGE.get(uuid1)));

        System.out.println("\nGet r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("\nSize: " + ARRAY_STORAGE.size());

        System.out.println("\nGet dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());

        fullStorage();
    }

    static void fullStorage(){
        for (int i = 0; i < 11; i++) {
            ARRAY_STORAGE.save(new Resume("13"));
        }
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
