package org.cat.eye.algorithms.interview.lru.cache;

import java.util.HashMap;

public class SimpleDaoImpl implements DAO<Integer, String> {

    private final HashMap<Integer, String> dataStore = new HashMap<>();

    @Override
    public String read(Integer key) {
        return dataStore.get(key);
    }

    @Override
    public void write(Integer key, String value) {
        dataStore.put(key, value);
    }

}
