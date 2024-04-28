package org.cat.eye.algorithms.interview.lru.cache;

import java.util.LinkedHashMap;

public class LruCache<K, V> {

    private final LinkedHashMap<K, V> cache = new LinkedHashMap<>();
    private final int maxSize;
    private final DAO<K, V> dao;

    public LruCache(int maxSize, DAO<K, V> dao) {
        this.maxSize = maxSize;
        this.dao = dao;
    }

    public V read(K key) {

        V value = cache.remove(key);

        if (value == null) {
            value = dao.read(key);
            if (cache.size() == maxSize) {
                // удалить элемент из начала очереди
                cache.pollFirstEntry();
            }
        }
        // вставить элемент в конец очереди
        cache.putLast(key, value);

        return value;
    }

    public void write(K key, V value) {
        cache.remove(key);
        dao.write(key, value);
    }

}
