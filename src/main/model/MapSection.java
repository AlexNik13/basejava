package main.model;

import java.io.Serializable;
import java.util.EnumMap;

public class MapSection<T extends Enum<T>, V> implements Serializable {

    private EnumMap<T, V> storage;
    private Class<T> enumT;

    public MapSection(Class<T> enumT) {
        this.storage = new EnumMap(enumT);
    }

    public void put(T enumT, V section) {
        storage.put(enumT, section);
    }

    public V getSection(T enumT) {
        return storage.get(enumT);
    }

    public V remove(T enumT) {
        return storage.remove(enumT);
    }

}
