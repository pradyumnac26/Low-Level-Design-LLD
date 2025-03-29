

public class Main {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);

        lru.put(1, 10);
        lru.put(2, 20);
        System.out.println(lru.get(1)); // Output: 10

        lru.put(3, 30);  // Evicts key 2
        System.out.println(lru.get(2)); // Output: -1

        lru.put(4, 40);  // Evicts key 1
        System.out.println(lru.get(1)); // Output: -1
        System.out.println(lru.get(3)); // Output: 30
        System.out.println(lru.get(4)); // Output: 40
    }
}
