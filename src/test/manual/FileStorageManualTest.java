package test.manual;

import main.model.Resume;
import main.repository.FileStorage;
import main.repository.abstractClass.Storage;

import java.io.File;
import java.nio.file.Path;

public class FileStorageManualTest {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public static void main(String[] args) {


        File file = new File("/home/user/UAPP/3/basejava/storage/");



        Storage storage = new FileStorage(file);

        Resume r1 = new Resume();
        r1.setUuid(UUID_1);
        Resume r2 = new Resume();
        r2.setUuid(UUID_2);
        Resume r3 = new Resume();
        r3.setUuid(UUID_3);

        storage.save(r1);
        storage.save(r2);
        storage.save(r3);

        storage.clear();
    }
}
