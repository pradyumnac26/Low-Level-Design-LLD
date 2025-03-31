

---

# 🗂️ MyHashMap Implementation in Java

## 📚 Overview
This project implements a custom `HashMap` data structure in Java, called `MyHashMap<K, V>`. It provides functionality similar to Java's built-in `HashMap` with basic operations such as:

- ✅ Inserting key-value pairs (`put(K key, V value)`)
- 🔍 Retrieving values using a key (`get(K key)`)

---

## 🎯 Features
- **Custom HashMap Implementation:** Allows storage of key-value pairs.
- **Generics Support:** Supports any type of key-value pairs.
- **Collision Handling:** Uses **separate chaining** with linked lists to handle hash collisions.
- **Dynamic Capacity Adjustment:** Table size is rounded to the nearest power of 2 for performance.

---

## ⚡️ How It Works

### 1. Constructor
- `MyHashMap()` - Initializes the hash table with the default size of 16.
- `MyHashMap(int capacity)` - Initializes the hash table with a specified size, rounded to the nearest power of 2 using `tableSizeFor()`.

---

### 2. put(K key, V value)
- Inserts a key-value pair into the hash table.
- If the key already exists, it updates the value.
- **Collision Handling:**  
   - If multiple keys hash to the same index, a linked list is used to store multiple entries at that index.

---

### 3. get(K key)
- Retrieves the value associated with the given key.
- **Collision Resolution:**  
   - If a collision occurs, it traverses the linked list to find the correct key.

---

## 🧠 How Collisions are Handled
- Collisions occur when multiple keys hash to the same index.
- **Collision Handling Mechanism:**
   - Uses **separate chaining** with a linked list.
   - When a collision occurs, new entries are added to the end of the linked list.
   - During `get()`, the list is traversed to retrieve the correct value.

✅ **Example of Collision:**
```
Index 5:
Entry(1, "hi") -> Entry(9, "friends") -> null
```
- Keys `1` and `9` hash to the same index (`5`), so they form a linked list.

---

## 📚 Code Structure

### 1. Entry Class
- Represents a key-value pair.
- `next` points to the next node in case of a collision.

```java
class Entry<K, V> {
    K key;
    V value;
    Entry next;  // Pointer to next Entry in case of collision
}
```

---

### 2. MyHashMap Class
- `hashTable` is an array of references to `Entry<K, V>` objects.
- The size of `hashTable` is always a power of 2 for efficient hashing.

```java
public class MyHashMap<K, V> {
    private static final int INITIAL_SIZE = 1 << 4;  // 16
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    Entry<K, V>[] hashTable;
}
```

---

## 🚀 Usage Instructions

### 1. Instantiate MyHashMap
- Creates a new `MyHashMap` with an initial capacity of `7`.
- Since the size is rounded up to the nearest power of 2, the actual size will be `8`.

```java
MyHashMap<Integer, String> map = new MyHashMap<>(7);
```

---

### 2. Insert Key-Value Pairs
- Adds 10 key-value pairs into the hash table.
- Handles collisions if multiple keys map to the same index.

```java
map.put(1, "hi");
map.put(2, "my");
map.put(3, "name");
map.put(4, "is");
map.put(5, "Shrayansh");
map.put(6, "how");
map.put(7, "are");
map.put(8, "you");
map.put(9, "friends");
map.put(10, "?");
```

---

### 3. Retrieve Values Using get()
- Retrieves the value for key `8`:
```java
String value = map.get(8);
System.out.println(value);
```
**Output:**
```
you
```

---

## 📝 Example Output
```
you
```

---

## ⚡️ Efficiency Analysis

### ✅ Time Complexity
| Operation  | Average Case | Worst Case (Collisions) |
|------------|---------------|------------------------|
| `put()`    | O(1)          | O(n)                   |
| `get()`    | O(1)          | O(n)                   |

### ✅ Space Complexity
- **O(n)** – Space required to store `n` entries.

---

## 🛠️ Future Improvements
- 🔄 **Dynamic Resizing:** Automatically resize the hash table when load factor exceeds a threshold.
- 🌳 **Switch to Balanced Tree:** Use a balanced tree for collision handling when the linked list becomes too long.

---

