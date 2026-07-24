# Exercise 5: Task Management System

## Objective
Develop a task management system using a Singly Linked List to allow for efficient dynamic data modifications.

## 1. Understand Linked Lists

### Singly vs Doubly Linked Lists
- **Singly Linked List**: Consists of nodes where each node contains data and a single pointer (`next`) to the next node in the sequence. It can only be traversed forward.
- **Doubly Linked List**: Consists of nodes containing data and two pointers (`prev` and `next`), pointing to the previous and next nodes. It can be traversed in both directions, making deletions easier if you only have a reference to the node itself, but requires extra memory for the second pointer.

## 2. Implementation details
- **Technologies Used**: Java 17
- **Files Included**:
  - `Task.java`: Defines the attributes of a task (`taskId`, `taskName`, `status`).
  - `Node.java`: Acts as the container/link for the Linked List, holding a `Task` and a `Node next`.
  - `SinglyLinkedList.java`: Implements adding, searching, traversing, and deleting operations by manipulating Node pointers.
  - `MainEx5.java`: Tests the list operations.

## 3. Analysis

### Time Complexity
| Operation | Time Complexity | Explanation |
| :--- | :--- | :--- |
| **Add (at end)** | $O(N)$ | Because we do not keep a `tail` pointer in this simple implementation, we must traverse the entire list from `head` to find the last node to append to. (If we kept a `tail` pointer, this would be $O(1)$). |
| **Search** | $O(N)$ | We must perform a linear search starting from the `head` until we find the target ID. |
| **Traverse** | $O(N)$ | We visit every node exactly once. |
| **Delete** | $O(N)$ | Finding the node takes $O(N)$. Once found, deleting it is $O(1)$ because we simply change the `next` pointer of the previous node. |

### Advantages over Arrays
- **Dynamic Size**: Unlike arrays, linked lists do not have a fixed size. They can grow and shrink dynamically as memory allows. You never encounter an "Array is full" error.
- **Efficient Deletions/Insertions**: In an array, deleting an element from the middle requires shifting all subsequent elements ($O(N)$). In a linked list, once the element is located, the actual deletion is instantaneous ($O(1)$) by just re-routing a pointer.

## Output Screenshot
```text
Added: Design Database
Added: Develop API
Added: Write Tests
--- Task List ---
Task [ID=T001, Name=Design Database, Status=In Progress]
Task [ID=T002, Name=Develop API, Status=Not Started]
Task [ID=T003, Name=Write Tests, Status=Not Started]
-----------------
Searching for T002...
Found: Task [ID=T002, Name=Develop API, Status=Not Started]
Deleted: Develop API
--- Task List ---
Task [ID=T001, Name=Design Database, Status=In Progress]
Task [ID=T003, Name=Write Tests, Status=Not Started]
-----------------
```
