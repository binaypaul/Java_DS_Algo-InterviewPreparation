package DataStructure.Neetcode150.Z_Caches.LRU;

import DataStructure.Concepts.LinkedList.*;
import JavaConcepts.Exception.*;
import java.util.*;
import org.w3c.dom.*;

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
    Map<Integer, Node> kvmap = null;
    int capacity;

    DoublyLinkedList dll = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        kvmap = new HashMap<>();
        dll = new DoublyLinkedList();
    }

    public int get(int key) {
        if(capacity == 0 || !kvmap.containsKey(key)) {
            return -1;
        }
        Node node = kvmap.get(key);
        dll.remove(node);
        dll.addToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;

        Node node = null;
        if(kvmap.containsKey(key)) {
            //Node is available
            node = kvmap.get(key);
            node.value = value;
            dll.remove(node);
            dll.addToFront(node);
        } else {
            //Brand-new node
            node = new Node(key, value);
            if(kvmap.size()>=capacity) {
                //Needs eviction
                Node removeLast = dll.removeLast();
                kvmap.remove(removeLast.key);
            }
            kvmap.put(key, node);
            dll.addToFront(node);
        }
    }

    private static class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoublyLinkedList {
        Node head, tail;

        public DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        private void addToFront(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        private Node removeLast() {
            Node node = tail.prev;
            remove(node);
            return node;
        }

        private void remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }
}