package DataStructure.Neetcode150.Z_Caches.LFU;

import java.util.HashMap;
import java.util.Map;

public class LFUCache_HashMap_Dll {

    // A single storage unit holding data, frequency, and pointers
    private static class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1; // Every new item starts with a frequency count of 1
        }
    }

    // A chain of nodes where we can easily add to the front and remove from the back
    private static class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            // Dummy head and tail nodes prevent empty list errors
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // Inserts a node right at the beginning (Most Recently Used position)
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        // Unlinks a node from anywhere in the chain
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        // Removes and returns the node at the very end (Least Recently Used position)
        Node removeLast() {
            if (size == 0) return null;
            Node lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        }
    }

    private final int capacity;
    private int minFreq; // Tracks the lowest usage frequency currently in the cache
    private final Map<Integer, Node> keyMap; // Maps key -> Node
    private final Map<Integer, DoublyLinkedList> freqMap; // Maps frequency -> DoublyLinkedList

    public LFUCache_HashMap_Dll(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    // Helper method to advance a node to its next frequency level
    private void updateFrequency(Node node) {
        int oldFreq = node.freq;
        int newFreq = oldFreq + 1;
        node.freq = newFreq;

        // 1. Remove from the old frequency list
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        // 2. If the old list is empty and it was our lowest frequency, bump minFreq up
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq = newFreq;
        }

        // 3. Move the node into the new frequency list
        freqMap.computeIfAbsent(newFreq, k -> new DoublyLinkedList()).addFirst(node);
    }

    public int get(int key) {
        if (capacity == 0 || !keyMap.containsKey(key)) {
            return -1;
        }

        Node node = keyMap.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        // Scenario A: Key already exists, update its value and bump frequency
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        // Scenario B: Cache is full, we must evict the least frequently used item
        if (keyMap.size() >= capacity) {
            DoublyLinkedList minFreqList = freqMap.get(minFreq);
            Node evictedNode = minFreqList.removeLast();
            if (evictedNode != null) {
                keyMap.remove(evictedNode.key);
            }
        }

        // Scenario C: Create and insert a brand new node
        Node newNode = new Node(key, value);
        keyMap.put(key, newNode);

        // Brand new nodes always start fresh with a frequency count of 1
        minFreq = 1;
        freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addFirst(newNode);
    }
}
