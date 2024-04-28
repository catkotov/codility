package org.cat.eye.algorithms.interview.lru.cache;

import java.util.LinkedHashMap;

public class LruCache<K, V> {

    private final LinkedHashMap<K, V> cache;
    private final DAO<K, V> dao;

    public LruCache(int maxSize, DAO<K, V> dao) {
        this.cache = new BoundedLinkedHashMap<>(maxSize);
        this.dao = dao;
    }

    public V read(K key) {

        V value = cache.remove(key);

        if (value == null) {
            value = dao.read(key);
        }
        // вставить элемент в конец очереди
        cache.put(key, value); // for Java SE 17

        return value;
    }

    public void write(K key, V value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
        }
        dao.write(key, value);
    }

}
