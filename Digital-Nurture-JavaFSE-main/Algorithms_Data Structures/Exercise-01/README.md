# Exercise 1: Inventory Management System

## Objective
Develop an inventory management system for a warehouse, focusing on efficient data storage and retrieval.

## 1. Understand the Problem
### Why are Data Structures and Algorithms Essential?
Handling a large warehouse inventory means processing thousands or millions of records. If inefficient data structures are used (like a simple unsorted array), looking up a specific product to update its stock could take `O(N)` time, which is very slow. Using the right algorithms and data structures ensures that retrieving, adding, and modifying stock levels happen instantaneously, saving computing resources and providing a smooth user experience.

### Types of Suitable Data Structures
- **ArrayList / Array**: Good if we mostly append items and just want a simple list. However, finding or deleting a specific product ID requires a slow linear search `O(N)`.
- **HashMap (Chosen Structure)**: Extremely well-suited because every product has a unique `productId`. We can use this ID as a key. A HashMap gives `O(1)` (constant time) complexity for finding, updating, and deleting products.
- **TreeMap / TreeSet**: If the requirements also asked to display products sorted by their ID or Price, a Tree-based structure would be useful, though operations take `O(log N)`.

## 2. Implementation details
- **Technologies Used**: Java 17
- **Files Included**:
  - `ProductEx1.java`: Defines the attributes of a product (ID, Name, Quantity, Price).
  - `Inventory.java`: Uses a `HashMap<String, ProductEx1>` to manage products.
  - `MainEx1.java`: Tests the system by adding, updating, and deleting products.

## 3. Analysis
### Time Complexity
Using a `HashMap` where the key is the `productId` provides the following average time complexities:
- **Add Product:** `O(1)` - Hashing the ID and inserting it is an instant operation.
- **Update Product:** `O(1)` - Finding the item by ID and replacing it is constant time.
- **Delete Product:** `O(1)` - Finding and removing the item takes constant time.

### How to Optimize These Operations
- For a single-threaded environment, `HashMap` is already perfectly optimized for these operations. 
- If this was a real-world enterprise system handling simultaneous requests from multiple cashiers or warehouse workers, we would optimize it by replacing `HashMap` with `ConcurrentHashMap` to ensure thread safety without locking the entire map.
- If memory overhead becomes an issue for millions of records, and IDs are sequential integers, a standard array could theoretically be used for perfect `O(1)` lookup without hashing overhead, though it loses flexibility with string IDs.

## Output Screenshot
```text
--- Adding Products ---
Product added: Laptop
Product added: Smartphone
Product added: Tablet
--- Current Inventory ---
Product [ID=P001, Name=Laptop, Quantity=10, Price=$1200.5]
Product [ID=P003, Name=Tablet, Quantity=15, Price=$300.0]
Product [ID=P002, Name=Smartphone, Quantity=25, Price=$800.0]
-------------------------
--- Updating Product ---
Product updated: Smartphone
--- Current Inventory ---
Product [ID=P001, Name=Laptop, Quantity=10, Price=$1200.5]
Product [ID=P003, Name=Tablet, Quantity=15, Price=$300.0]
Product [ID=P002, Name=Smartphone, Quantity=30, Price=$800.0]
-------------------------
--- Deleting Product ---
Product deleted: Laptop
--- Current Inventory ---
Product [ID=P003, Name=Tablet, Quantity=15, Price=$300.0]
Product [ID=P002, Name=Smartphone, Quantity=30, Price=$800.0]
-------------------------
```
