
import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final Node head = new Node(0, 0), tail = new Node(0, 0);
    private final Map<Integer, Node> map = new HashMap<>();
    private int capacity;  // Marked as private for encapsulation

    // Constructor to initialize the cache with a given capacity
    public LRUCache(int _capacity) {
        this.capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    // Synchronized get method to ensure thread safety
    public synchronized int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);   // Remove the node from current position
            insert(node);   // Move node to the front (most recently used)
            return node.value;
        } else {
            return -1;      // Key not found
        }
    }

    // Synchronized put method to ensure thread safety
    public synchronized void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));  // Remove the existing node
        }
        if (map.size() == capacity) {
            remove(tail.prev);     // Remove the least recently used (LRU) node
        }
        insert(new Node(key, value)); // Insert the new node at the front
    }

    // Getter method for capacity (optional, if needed)
    public int getCapacity() {
        return capacity;
    }

    // Removes a node from the doubly linked list
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Inserts a node at the front (most recently used position)
    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // Node class definition
    class Node {
        Node prev, next;
        int key, value;

        // Constructor to initialize a node with key-value pair
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}
