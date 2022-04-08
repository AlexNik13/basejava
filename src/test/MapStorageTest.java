package test;

import main.repository.MapStorage;
import org.junit.jupiter.api.Test;

class MapStorageTest extends StorageTest {
    public MapStorageTest() {
        super(new MapStorage());
    }

    @Test
    void getIndex() {
        // ignore test
    }
}