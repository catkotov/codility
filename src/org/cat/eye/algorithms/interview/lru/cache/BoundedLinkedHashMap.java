package org.cat.eye.algorithms.interview.lru.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class BoundedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private final int maxSize;

    public BoundedLinkedHashMap(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return this.size() > maxSize;
    }

}
