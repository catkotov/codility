package org.cat.eye.algorithms.interview.lru.cache;

public interface DAO<K, V> {

    V read(K key);

    void write (K key, V value);

}
