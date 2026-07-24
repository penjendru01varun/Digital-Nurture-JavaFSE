# Exercise 3: Sorting Customer Orders

## Objective
Sort customer orders by their total price to prioritize high-value orders using different sorting algorithms.

## 1. Understand Sorting Algorithms

### Different Sorting Algorithms
- **Bubble Sort**: A simple, comparison-based algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. It "bubbles" the largest elements to the end of the list.
- **Insertion Sort**: Builds the sorted array one element at a time by picking the next element and inserting it into its correct position among the previously sorted elements. Good for very small or nearly sorted datasets.
- **Merge Sort**: A "divide and conquer" algorithm that recursively divides the list into halves, sorts them, and then merges the sorted halves. Highly stable and predictable.
- **Quick Sort**: Another "divide and conquer" algorithm that selects a 'pivot' element and partitions the other elements into two sub-arrays, according to whether they are less than or greater than the pivot.

## 2. Implementation details
- **Technologies Used**: Java 17
- **Files Included**:
  - `Order.java`: Defines the attributes of an order (`orderId`, `customerName`, `totalPrice`).
  - `SortUtil.java`: Contains implementations for Bubble Sort and Quick Sort.
  - `MainEx3.java`: Tests both sorting algorithms.

## 3. Analysis

### Performance Comparison
| Algorithm | Average Time Complexity | Worst Case Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- |
| **Bubble Sort** | $O(N^2)$ | $O(N^2)$ | $O(1)$ |
| **Quick Sort** | $O(N \log N)$ | $O(N^2)$ | $O(\log N)$ |

### Why Quick Sort is generally preferred over Bubble Sort
**Quick Sort is drastically faster for large datasets.** 
Bubble sort requires nested loops that compare every single element against the others, resulting in quadratic time ($O(N^2)$). For 10,000 orders, Bubble Sort could perform 100,000,000 operations.

Quick Sort uses a divide-and-conquer strategy, partitioning the array around a pivot. On average, this drastically reduces the number of comparisons to $O(N \log N)$. For 10,000 orders, Quick Sort performs roughly 130,000 operations. The performance difference in a real e-commerce platform handling thousands of daily orders is night and day.

## Output Screenshot
```text
--- Before Bubble Sort ---
Order [ID=O001, Customer=Alice, Total Price=$250.5]
Order [ID=O002, Customer=Bob, Total Price=$15.0]
Order [ID=O003, Customer=Charlie, Total Price=$99.99]
Order [ID=O004, Customer=Diana, Total Price=$500.0]
Order [ID=O005, Customer=Eve, Total Price=$120.0]

--- After Bubble Sort ---
Order [ID=O002, Customer=Bob, Total Price=$15.0]
Order [ID=O003, Customer=Charlie, Total Price=$99.99]
Order [ID=O005, Customer=Eve, Total Price=$120.0]
Order [ID=O001, Customer=Alice, Total Price=$250.5]
Order [ID=O004, Customer=Diana, Total Price=$500.0]

--- Before Quick Sort ---
Order [ID=O001, Customer=Alice, Total Price=$250.5]
Order [ID=O002, Customer=Bob, Total Price=$15.0]
Order [ID=O003, Customer=Charlie, Total Price=$99.99]
Order [ID=O004, Customer=Diana, Total Price=$500.0]
Order [ID=O005, Customer=Eve, Total Price=$120.0]

--- After Quick Sort ---
Order [ID=O002, Customer=Bob, Total Price=$15.0]
Order [ID=O003, Customer=Charlie, Total Price=$99.99]
Order [ID=O005, Customer=Eve, Total Price=$120.0]
Order [ID=O001, Customer=Alice, Total Price=$250.5]
Order [ID=O004, Customer=Diana, Total Price=$500.0]
```
