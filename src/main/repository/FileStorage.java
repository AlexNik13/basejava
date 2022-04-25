package main.repository;

import main.model.Resume;
import main.repository.abstractClass.AbstractFileStorage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileStorage extends AbstractFileStorage {

    public FileStorage(File directory) {
        super(directory);
    }

    @Override
    protected void doWrite(Resume resume, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(resume);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Resume> getAll() {
        List<Resume> resumes = new ArrayList<>();
        File[] files = getDirectory().listFiles();
        for (File file : files) {
            resumes.add(doGet(file));
        }
        return resumes;
    }
}
