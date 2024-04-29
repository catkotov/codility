package org.cat.eye.algorithms.interview.lru.cache;

public class LruCacheTest {

    public static void main(String[] args) {

        SimpleDaoImpl dao = new SimpleDaoImpl();
        LruCache<Integer, String> cache = new LruCache<>(5, dao);

        cache.write(1, "one");
        cache.write(2, "two");
        cache.write(3, "three");
        cache.write(4, "four");
        cache.write(5, "five");
        cache.write(6, "six");
        cache.write(7, "seven");

        cache.read(1);
        cache.read(2);
        cache.read(3);
        cache.read(4);
        cache.read(5);

        cache.read(3);
        String seven = cache.read(7);
    }

}
