# Exercise 2: Writing Basic JUnit Tests

## Scenario
You need to write basic JUnit tests for a simple Java class.

## Steps
1. Create a Java class with methods to test.
2. Write JUnit tests for these methods.

## Solution Code

```java
// Calculator.java
public class Calculator {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

// CalculatorTest.java
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calc.subtract(3, 2));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calc.multiply(2, 3));
    }
}
```

## Output
```
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
```
