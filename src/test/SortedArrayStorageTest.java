package test;

import main.model.Resume;
import main.repository.SortedArrayStorage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Test
    void save() {
        getStorage().save(new Resume("new"));
        getStorage().save(new Resume("new"));
        int result = getStorage().size();
        assertEquals(4, result);
    }
}