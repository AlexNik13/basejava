package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        ListStorageTest.class,
        MapStorageTest.class,
        MapHashStorageTest.class,
        FileStorageTest.class,
        AbstractPathStorageTest.class
})
public class RunAllTest {
}
