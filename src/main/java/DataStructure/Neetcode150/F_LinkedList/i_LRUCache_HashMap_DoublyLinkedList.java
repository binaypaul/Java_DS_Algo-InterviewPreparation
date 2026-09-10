package DataStructure.Neetcode150.F_LinkedList;

import DataStructure.Concepts.LinkedList.*;
import java.util.*;

public class i_LRUCache_HashMap_DoublyLinkedList {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 10);                      // cache: {1=10}
        System.out.println(lruCache.get(1));      // return 10
        lruCache.put(2, 20);                      // cache: {1=10, 2=20}
        lruCache.put(3, 30);                      // cache: {2=20, 3=30}, key=1 was evicted
        System.out.println(lruCache.get(2));      // returns 20
        System.out.println(lruCache.get(1));      // return -1 (not found)
        System.out.println(lruCache.get(3));      // return 30
    }
}

class LRUCache {
    Map<Integer, DoublyListNode> lookUpMap = null;
    Map<Integer, Integer> kvmap = null;

    int capacity;
    DoublyListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        lookUpMap = new HashMap<>();
        kvmap = new HashMap<>();
    }

    public int get(int key) {
        if(lookUpMap.containsKey(key)) {
            int value = remove(key);
            insert(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(lookUpMap.containsKey(key)) {
            remove(key);
        } else if(lookUpMap.size()>=capacity) {
            remove(tail.val);
        }
        insert(key, value);
    }

    private int remove(int key) {
        if(lookUpMap.containsKey(key)) {
            int value = kvmap.remove(key);
            DoublyListNode node = lookUpMap.remove(key);
            if(head==node && tail == node) {
                // when capacity is 1
                head = null;
                tail = null;
            } else if(tail==node) {
                tail=node.nextNode;
            } else if(head==node) {
                head=node.prevNode;
            } else {
                DoublyListNode prev = node.prevNode;
                DoublyListNode next = node.nextNode;
                prev.nextNode = next;
                next.prevNode = prev;
            }
            return value;
        }
        return -1;
    }

    private void insert(int key, int value) {
        DoublyListNode node = new DoublyListNode(key);

        if (lookUpMap.isEmpty()) {
            lookUpMap.put(key, node);
            kvmap.put(key, value);
            head = node;
            tail = node;
        } else if(lookUpMap.size()<capacity){
            lookUpMap.put(key, node);
            kvmap.put(key, value);
            head.nextNode = node;
            node.prevNode = head;
            head = node;
        }
    }
}