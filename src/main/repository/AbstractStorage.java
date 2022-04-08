package main.repository;

public abstract class AbstractStorage implements Storage {

    protected abstract int getIndex(String uuid);
}
