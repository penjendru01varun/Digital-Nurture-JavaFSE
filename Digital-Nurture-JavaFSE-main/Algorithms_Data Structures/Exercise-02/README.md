# Exercise 2: E-commerce Platform Search Function

## Objective
Optimize the search functionality of an e-commerce platform using appropriate search algorithms.

## 1. Understand Asymptotic Notation

### What is Big O Notation?
Big O notation is a mathematical concept used in computer science to describe the performance or complexity of an algorithm. It specifically describes the worst-case scenario, answering the question: "As the number of elements ($N$) grows arbitrarily large, how much longer will the algorithm take to run, or how much more memory will it need?" It helps programmers compare algorithms to choose the most efficient one.

### Best, Average, and Worst-Case Scenarios
For a standard array search operation of $N$ items:
- **Best-case scenario**: The target item is the very first one checked. The algorithm stops immediately. Complexity: $O(1)$.
- **Worst-case scenario**: The target item is the very last one checked, or not present at all. The algorithm must check every single item or perform the maximum number of allowed steps. Complexity: e.g., $O(N)$ for linear search.
- **Average-case scenario**: The target item is somewhere in the middle. Mathematically, the expected number of steps over many random trials. Complexity: e.g., $O(N/2)$ which simplifies to $O(N)$ for linear search.

## 2. Implementation details
- **Technologies Used**: Java 17
- **Files Included**:
  - `ProductEx2.java`: Defines the attributes of a product.
  - `SearchUtil.java`: Contains implementations for Linear Search and Binary Search.
  - `MainEx2.java`: Tests both search algorithms.

## 3. Analysis

### Time Complexity Comparison
| Algorithm | Best Case | Average Case | Worst Case | Prerequisite |
| :--- | :--- | :--- | :--- | :--- |
| **Linear Search** | $O(1)$ | $O(N)$ | $O(N)$ | None (works on unsorted data) |
| **Binary Search** | $O(1)$ | $O(\log N)$ | $O(\log N)$ | Data **must** be sorted first |

### Which algorithm is more suitable?
For an e-commerce platform with a massive product catalog (e.g., millions of items), **Binary Search is significantly more suitable** for performance. Searching 1,000,000 sorted items using Binary Search takes at most 20 comparisons ($O(\log N)$), whereas Linear Search could take up to 1,000,000 comparisons. 

However, since Binary Search strictly requires a sorted dataset, the platform must ensure the underlying array/database is kept sorted by the search attribute (e.g., Product Name), or use a database index (like a B-Tree) which behaves similarly to Binary Search.

## Output Screenshot
```text
--- Linear Search ---
Found: Product [ID=P103, Name=Tablet, Category=Electronics]

--- Binary Search ---
Found: Product [ID=P103, Name=Tablet, Category=Electronics]
```
