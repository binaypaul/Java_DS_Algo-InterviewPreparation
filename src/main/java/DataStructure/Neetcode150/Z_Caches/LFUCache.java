package DataStructure.Neetcode150.Z_Caches;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Design and implement a data structure for a Least Frequently Used (LFU) cache. It should support the following operations:
 * LFUCache (Capacity c): Initialize LFU cache with positive size capacity c.
 * get(key) - Returns the value of the given key if it exists in the cache; otherwise, returns -1.
 * put(key, value) - Inserts or updates the key-value pair in the cache.
 * If the cache reaches capacity, remove the least frequently used item before adding the new item.
 * If there is a tie between keys with the same frequency, the least recently used (LRU) key among them should be removed.
 * The functions get and put must each run in O(1) average time complexity.
 *
 * ["put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [3], [4], [5,5]]
 * Output: 1 -1 -1 4
 */


public class LFUCache {
    int capacity;
    Map<Integer, Integer> keyValueMap = null;
    Map<Integer, Integer> keyFreqMap = null;
    Map<Integer, LinkedHashSet<Integer>> feqKeySetMap = null;
    int minimumFreq = 1;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyValueMap = new HashMap<>(capacity);
        keyFreqMap = new HashMap<>(capacity);
        feqKeySetMap = new HashMap<>(capacity);
    }

    public void put (Integer key, Integer value) {
        if(!keyValueMap.containsKey(key)) {
            if(capacity == keyValueMap.size()) {
                Integer evictKey = feqKeySetMap.get(minimumFreq).removeFirst();
                keyFreqMap.remove(evictKey);
                keyValueMap.remove(evictKey);
            }
            keyFreqMap.put(key, 1);
            feqKeySetMap.compute(1, (k,v) -> {
               if(v == null) {
                   v = new LinkedHashSet<>();
               }
               v.add(key);
               return v;
            });
            minimumFreq = 1;
        } else {
            int oldfreq = keyFreqMap.get(key);
            feqKeySetMap.compute(oldfreq, (k, v) -> {
                v.remove(key);
                return v;
            });

            keyFreqMap.put(key, oldfreq + 1);
            feqKeySetMap.compute(oldfreq + 1, (freq, keySet) -> {
                if(keySet==null) {
                    keySet = new LinkedHashSet<Integer>();
                }
                keySet.add(key);
                return keySet;
            });
            minimumFreq = Math.min(minimumFreq, oldfreq + 1);
        }

        keyValueMap.put(key, value);
    }

    public Integer get(Integer key) {
        if(!keyValueMap.containsKey(key)) {
            return -1;
        } else {
            int oldFreq = keyFreqMap.get(key);
            feqKeySetMap.compute(oldFreq, (freq, keySet)->{
                keySet.remove(key);
                return keySet;
            });
            keyFreqMap.put(key, oldFreq+1);
            feqKeySetMap.compute(oldFreq+1, (freq, keySet)->{
                if(keySet==null) {
                    keySet = new LinkedHashSet<Integer>();
                }
                keySet.add(key);
                return keySet;
            });
            if(feqKeySetMap.get(minimumFreq).isEmpty()) {
                minimumFreq = oldFreq + 1;
            }
            return keyValueMap.get(key);
        }
    }

    @Override
    public String toString() {
        return "LFUCache{" +
                "capacity=" + capacity +
                ", minimumFreq=" + minimumFreq +
                ", keyValueMap=" + keyValueMap +
                ", keyFreqMap=" + keyFreqMap +
                ", feqKeySetMap=" + feqKeySetMap +
                '}';
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3);
        cache.put(1,1);
        System.out.println(cache);
        cache.put(2,2);
        System.out.println(cache);
        cache.get(1);
        System.out.println(cache);
        cache.put(3,3);
        System.out.println(cache);
        cache.get(2);
        System.out.println(cache);
        cache.get(2);
        System.out.println(cache);
        cache.put(4,4);
        System.out.println(cache);
        cache.get(1);
        System.out.println(cache);
        cache.put(5,5);
        System.out.println(cache);
        cache.get(5);
        System.out.println(cache);
        cache.put(6,6);
        System.out.println(cache);
    }
}
 /*
         * ["put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
         * [[1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [3], [4], [5,5]]
         * Output: 1 -1 -1 4
        */