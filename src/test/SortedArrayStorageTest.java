package test;

import main.exception.ExistStorageException;
import main.model.Resume;
import main.repository.SortedArrayStorage;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Override
    @Test
    public void save() {
        assertThrows(ExistStorageException.class, () -> {
            getStorage().save(new Resume("new"));
            getStorage().save(new Resume("new"));
        });
        int result = getStorage().size();
        assertEquals(4, result);
    }
}