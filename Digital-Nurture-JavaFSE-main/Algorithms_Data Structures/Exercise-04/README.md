# Exercise 4: Employee Management System

## Objective
Develop an employee management system to efficiently manage records using an Array.

## 1. Understand Array Representation

### Memory Representation and Advantages
- **Contiguous Memory**: Arrays are stored in a single, continuous block of memory. If the first element is at memory address `X`, the next element is at `X + size_of_element`.
- **Advantages**: 
  - **Fast Access**: Because of contiguous memory, accessing any element by its index takes exactly `O(1)` time. The CPU can calculate the exact memory address instantly using a simple formula (`Base_Address + Index * Size`).
  - **Cache Friendliness**: CPUs read memory in chunks (cache lines). Reading an array is very fast because the elements are packed tightly together, meaning sequential access is highly optimized by hardware.

## 2. Implementation details
- **Technologies Used**: Java 17
- **Files Included**:
  - `Employee.java`: Defines the attributes of an employee (`employeeId`, `name`, `position`, `salary`).
  - `EmployeeManagementSystem.java`: Manages the storage of `Employee` objects using a standard Java array, keeping track of the current `count`.
  - `MainEx4.java`: Tests adding, searching, traversing, and deleting employees.

## 3. Analysis

### Time Complexity
| Operation | Time Complexity | Explanation |
| :--- | :--- | :--- |
| **Add** | $O(1)$ | If there's space, we simply place the new employee at the `count` index and increment `count`. |
| **Search** | $O(N)$ | We must perform a linear search to find an employee by their ID. |
| **Traverse** | $O(N)$ | We must visit every active element in the array from `0` to `count-1`. |
| **Delete** | $O(N)$ | Finding the element takes $O(N)$. Furthermore, to keep the array contiguous, all elements to the right of the deleted item must be shifted one position to the left, taking up to $O(N)$ operations. |

### Limitations of Arrays
- **Fixed Size**: Once initialized, a standard array cannot change its size. If it gets full, you cannot add more employees without creating a brand new, larger array and copying all elements over.
- **Costly Insertions/Deletions**: Shifting elements to maintain order or fill gaps after deletion takes $O(N)$ time, which is inefficient for massive datasets with frequent modifications.

### When to use them
Use arrays when the maximum number of elements is known in advance, memory is tight, and you primarily need fast, index-based read access with infrequent deletions or insertions in the middle of the dataset.

## Output Screenshot
```text
Added: Alice
Added: Bob
Added: Charlie
--- Employee List ---
Employee [ID=E001, Name=Alice, Position=Developer, Salary=$75000.0]
Employee [ID=E002, Name=Bob, Position=Manager, Salary=$85000.0]
Employee [ID=E003, Name=Charlie, Position=Analyst, Salary=$65000.0]
---------------------
Searching for E002...
Found: Employee [ID=E002, Name=Bob, Position=Manager, Salary=$85000.0]
Deleted: Bob
--- Employee List ---
Employee [ID=E001, Name=Alice, Position=Developer, Salary=$75000.0]
Employee [ID=E003, Name=Charlie, Position=Analyst, Salary=$65000.0]
---------------------
```
