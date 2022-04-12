package test;

import main.exception.StorageException;
import main.model.Resume;
import main.repository.Storage;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractArrayStorageTest extends StorageTest{
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test
    void saveOverflow() {
        int maxSize = 0;
        try {
            Field field = getStorage().getClass().getSuperclass().getDeclaredField("STORAGE_LIMIT");
            field.setAccessible(true);
            maxSize = (int) field.get(getStorage().getClass().getSuperclass());
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        int size = maxSize;
        assertThrows(StorageException.class, () -> {
            for (int i = 0; i < size + 1; i++) {
                getStorage().save(new Resume("i"));
            }
        });
    }
}
