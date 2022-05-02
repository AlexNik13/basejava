package main.repository;

import main.model.Resume;
import main.repository.abstractClass.AbstractPathStorage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ObjectStreamPathStorage extends AbstractPathStorage {

    public ObjectStreamPathStorage(String dir) {
        super(dir);
    }

    @Override
    protected void doWrite(Resume r, OutputStream os) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(r);
        oos.close();
    }

    @Override
    protected Resume doRead(InputStream is) throws IOException {
        ObjectInputStream ois = new ObjectInputStream(is);
        Resume resume = null;
        try {
            resume = (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ois.close();
        }
        return resume;
    }

    @Override
    public List<Resume> getAll() {
        List<Resume> resumes = new ArrayList<>();
        try (Stream<Path> pathStream = Files.list(directory).filter(path -> path.toFile().isFile())) {
            pathStream.forEach(
                    path -> resumes.add(doGet(path))
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resumes;
    }
}
