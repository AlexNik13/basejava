package main.repository.abstractClass;

import main.exception.StorageException;
import main.model.Resume;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {

    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.exists()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not exists");
        }
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            }
        }
    }

    @Override
    public int size() {
        try {
            return (int) Files.list(Path.of(directory.getPath())).filter(path -> path.toFile().isFile()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try {
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    protected abstract void doWrite(Resume r, File file) throws IOException;

    @Override
    protected Resume doGet(File file) {
        try (FileInputStream fin = new FileInputStream(file)) {
            ObjectInputStream ois = new ObjectInputStream(fin);
            Resume resume = (Resume) ois.readObject();
            ois.close();
            return resume;
        } catch (IOException | ClassNotFoundException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected void doDelete(File file) {
        file.delete();
    }

    protected File getDirectory() {
        return directory;
    }
}
