package DataStructure.Neetcode150.F_LinkedList;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

class i_LRUCache {
    int capacity;
    Map<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
          return size()>capacity;
      }
    };

    public i_LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        return Objects.requireNonNullElse(cache.get(key), -1);
    }

    public void put(int key, int value, int[] nums1, int[] nums2) {
        cache.put(key, value);

    }

    public static void main(String[] args) {
        i_LRUCache cache = new i_LRUCache(5);
    }
}