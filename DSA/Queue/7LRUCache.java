// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

// Implement the LRUCache class:

// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

// Example 1:

// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]

// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4

// Link : https://leetcode.com/problems/lru-cache/
// Solution : https://www.youtube.com/watch?v=xDEuM5qa0zg

package Queue;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    // Step 1: Define the doubly linked list nodes and pointers
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    // Step 2: Use a hashmap for quick access to nodes based on keys
    Map<Integer, Node> map = new HashMap<>();

    // Step 3: Maintain the capacity of the LRUCache
    int capacity;

    // Step 4: Constructor to initialize the LRUCache with a given capacity
    public LRUCache(int _capacity) {
        capacity = _capacity;

        // Step 5: Connect the head and tail nodes in the doubly linked list
        head.next = tail;
        tail.prev = head;
    }

    // Step 6: Get the value associated with a key from the LRUCache
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // Move the accessed node to the front of the list (most recently used)
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    // Step 7: Put a key-value pair into the LRUCache
    public void put(int key, int value) {
        // If the key already exists, remove the existing node
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        // If the LRUCache is at its capacity, remove the least recently used node
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        // Insert the new node at the front of the list (most recently used)
        insert(new Node(key, value));
    }

    // Step 8: Remove a node from the doubly linked list
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Step 9: Insert a node at the front of the doubly linked list
    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // Step 10: Define the Node class for the doubly linked list
    class Node {
        Node prev, next;
        int key, value;

        // Constructor to initialize the Node with a key and value
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}
