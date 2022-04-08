package main.repository.base;

import main.exception.NotExistStorageException;

public abstract class AbstractStorage implements Storage {



    protected abstract int getIndex(String uuid);


}
