package test;

import main.exception.ExistStorageException;
import main.exception.StorageException;
import main.model.Resume;
import main.repository.SortedArrayStorage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Test
    void save() {
        Exception exception = assertThrows(ExistStorageException.class, () -> {
            getStorage().save(new Resume("new"));
            getStorage().save(new Resume("new"));
        });
        int result = getStorage().size();
        assertEquals(4, result);
    }

    @Test
    void saveFull() {
        Exception exception = assertThrows(StorageException.class, () -> {
            for (int i = 0; i < 10; i++) {
                getStorage().save(new Resume("new resume" + i));
            }
        });
    }
}