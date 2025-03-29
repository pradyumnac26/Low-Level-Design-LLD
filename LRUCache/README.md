# 🧠 Designing an LRU Cache in Java

## ✅ **Overview**

This project implements a **Least Recently Used (LRU) Cache** in Java using a combination of:
- **HashMap** for fast key-value lookups.
- **Doubly Linked List** to maintain the order of usage.
- **Synchronized Methods** to ensure thread safety.

### 📌 **What is an LRU Cache?**
An **LRU Cache** is a data structure that stores a fixed number of items and removes the **least recently used (LRU)** item when the cache exceeds its capacity.

- **Most Recently Used (MRU)** item → Moved to the front.
- **Least Recently Used (LRU)** item → Removed when the cache is full.

---

## 🎯 **Key Requirements**

### 🔥 1. `put(key, value)`
- Add or update a key-value pair.
- If the cache reaches its capacity:
    - Remove the **least recently used** item before inserting the new one.
- Time Complexity: `O(1)`

---

### 🔥 2. `get(key)`
- Retrieve the value associated with a key.
- If the key exists:
    - Move the node to the **front** (MRU position).
    - Return the value.
- If the key doesn’t exist:
    - Return `-1`.
- Time Complexity: `O(1)`

---

### 🔥 3. Fixed Capacity
- The cache should have a fixed size specified during initialization.

---

### 🔥 4. Thread Safety
- The cache should be **thread-safe** to allow concurrent access from multiple threads.
- `synchronized` ensures that only one thread accesses or modifies the cache at a time.

---

## 🚀 **How the LRU Cache Works**

### 📚 **Data Structures Used**
1. **HashMap (map)** – Stores `key -> Node` pairs.
    - Provides `O(1)` lookup, insertion, and deletion.
2. **Doubly Linked List** – Maintains order of recently accessed elements.
    - **Head** points to the **most recently used** (MRU) item.
    - **Tail** points to the **least recently used** (LRU) item.

---

### 📚 **How Operations Work**

✅ **put(key, value)**
- Check if the key exists:
    - If yes, update the value and move the node to the front.
- If the cache is full:
    - Remove the **LRU** node from the tail.
- Insert the new node at the **front**.

✅ **get(key)**
- If the key exists:
    - Move the node to the front (MRU).
    - Return the value.
- If the key doesn’t exist:
    - Return `-1`.

---

## 🔐 **Synchronization in Java**

### 📚 **What is Synchronization?**
In Java, **synchronization** is a mechanism that ensures that only **one thread** can access a synchronized method or block at a time.

✅ **Why Use `synchronized` in LRU Cache?**
- Prevents multiple threads from accessing or modifying the cache simultaneously.
- Ensures that operations on `HashMap` and the linked list remain consistent.

---

### 📚 **How Does `synchronized` Work?**
- When a thread enters a synchronized method:
    - It acquires the **monitor lock** on the object.
    - Other threads trying to access the synchronized method will be blocked.
- The lock is released when:
    - The thread exits the method.
    - An exception occurs within the method.

---

### 📚 **When to Use Synchronization?**
- Use `synchronized` when multiple threads can access shared resources.
- Synchronize only the critical sections to prevent deadlocks and performance issues.

---