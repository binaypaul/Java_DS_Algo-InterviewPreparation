package DataStructure.Neetcode150.a_a_Practice.Mock6_4Q90Min;

import java.util.*;

public class LRUCache extends LinkedHashMap <Integer, Integer> {
    private int capacity;

    public LRUCache (int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        if(this.size() > capacity)
            return true;
        return false;
    }
}
