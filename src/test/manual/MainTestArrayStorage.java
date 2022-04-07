package test.manual;

import main.model.Resume;
import main.repository.ArrayStorage;

/**
 * Test for your main.repository.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";


    public static void main(String[] args) {


        Resume r1 = new Resume();
        r1.setUuid(UUID_1);
        Resume r2 = new Resume();
        r2.setUuid(UUID_2);
        Resume r3 = new Resume();
        r3.setUuid(UUID_3);

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        Resume resume = new Resume(UUID_1);

        System.out.println("\nNo update : " + (resume == ARRAY_STORAGE.get(UUID_1)));
        ARRAY_STORAGE.update(resume);
        System.out.println("\nAfter update : " + (resume == ARRAY_STORAGE.get(UUID_1)));


        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        //  System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.delete(r3.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
