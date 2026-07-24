# Exercise 6: Library Management System

## Objective
Develop a library management system to search for books by title using Linear and Binary search algorithms.

## 1. Understand Search Algorithms

### Linear vs Binary Search
- **Linear Search**: Starts at the beginning of the list and checks every single element sequentially until it finds the target or reaches the end.
- **Binary Search**: Starts with a sorted list. It compares the target value to the middle element of the list. If they are unequal, the half in which the target cannot lie is eliminated, and the search continues on the remaining half, again taking the middle element to compare to the target value, and repeating this until the target value is found.

## 2. Implementation details
- **Technologies Used**: Java 17
- **Files Included**:
  - `Book.java`: Defines the attributes of a book (`bookId`, `title`, `author`).
  - `Library.java`: Contains implementations for Linear Search and Binary Search.
  - `MainEx6.java`: Tests searching operations.

## 3. Analysis

### Time Complexity
| Algorithm | Average Time Complexity | Worst Case Time Complexity | Prerequisite |
| :--- | :--- | :--- | :--- |
| **Linear Search** | $O(N)$ | $O(N)$ | None |
| **Binary Search** | $O(\log N)$ | $O(\log N)$ | Must be sorted |

### When to use each algorithm based on dataset size and order
- **Small Dataset (e.g., 50 books)**: Linear search is perfectly fine. The overhead of sorting the list to prepare it for binary search might actually take longer than simply scanning the 50 items.
- **Large, Unordered Dataset that changes constantly**: If a library adds new books every hour, keeping the array constantly sorted so you can perform Binary Search is extremely expensive ($O(N \log N)$ to sort or $O(N)$ to shift items down for insertion). In cases where the array cannot be kept sorted, you must rely on Linear Search (or switch to a better structure like a Hash Map or Binary Search Tree).
- **Large, Ordered Dataset (e.g., millions of books)**: Binary Search is absolutely essential. A database index operates similarly. Searching through 1 million books takes at most ~20 operations with Binary Search, making it instantly responsive.

## Output Screenshot
```text
--- Linear Search ---
Found: Book [ID=B002, Title='1984', Author='George Orwell']

Sorting books by title for binary search...

--- Binary Search ---
Found: Book [ID=B002, Title='1984', Author='George Orwell']
```
