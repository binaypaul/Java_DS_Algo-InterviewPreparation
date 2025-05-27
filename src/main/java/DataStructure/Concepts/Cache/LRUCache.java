package DataStructure.Concepts.Cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private Map<K,V> cache = new LinkedHashMap<K,V>(capacity, 7.5f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return size()>capacity;
        }
    };

    public V get(K key) {
        return cache.get(key);
    }

    public V put(K key, V value) {
        return cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);

        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");
        System.out.println(lruCache.cache); // {1=one, 2=two, 3=three}

        lruCache.get(2);
        System.out.println(lruCache.cache); // {1=one, 3=three, 2=two}

        lruCache.put(4, "four");
        System.out.println(lruCache.cache); // {3=three, 2=two, 4=four}
    }
}
