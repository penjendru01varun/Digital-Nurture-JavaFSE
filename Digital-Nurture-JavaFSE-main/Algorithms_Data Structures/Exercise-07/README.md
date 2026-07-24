# Exercise 7: Financial Forecasting

## Objective
Develop a financial forecasting tool that predicts future values using a recursive algorithm.

## 1. Understand Recursive Algorithms

### The Concept of Recursion
Recursion is a programming technique where a method calls itself to solve a smaller instance of the same problem. It consists of two main parts:
- **Base Case**: The condition under which the recursion stops. Without this, the method would call itself infinitely, leading to a `StackOverflowError`.
- **Recursive Case**: The part where the method calls itself with modified parameters, moving closer to the base case.

Recursion simplifies problems that can naturally be broken down into identical sub-problems, such as calculating factorials, traversing tree data structures, or in this case, calculating compound growth over discrete periods.

## 2. Implementation details
- **Technologies Used**: Java 17
- **Files Included**:
  - `FinancialForecasting.java`: Contains the recursive method `calculateFutureValue`.
  - `MainEx7.java`: Tests the algorithm with a sample current value and growth rate.

## 3. Analysis

### Time Complexity
- **Time Complexity**: $O(N)$, where $N$ is the number of periods. The method calls itself exactly $N$ times, performing a constant $O(1)$ multiplication operation each time.
- **Space Complexity**: $O(N)$ due to the call stack. Each recursive call adds a new frame to the system's memory stack. If $N$ is extremely large, this will cause a Stack Overflow.

### How to Optimize
If the number of periods was extremely high or if this function was being called thousands of times for the exact same inputs in a larger simulation:
- **Mathematical Formula**: The ultimate optimization is abandoning recursion/loops altogether and using the standard mathematical formula $V = P(1+r)^t$ in $O(1)$ time.
- **Memoization**: If calculating complex sub-problems repeatedly, we could store the results of previous calculations in a HashMap so they don't need to be recalculated.
- **Iterative Approach**: We could use a standard `for` loop instead of recursion. An iterative loop operates in $O(N)$ time but $O(1)$ space, entirely preventing any risk of a Stack Overflow.

## Output Screenshot
```text
Current Value: $1000.00
Growth Rate: 5.00%
Periods: 10
Predicted Future Value: $1628.89
```
