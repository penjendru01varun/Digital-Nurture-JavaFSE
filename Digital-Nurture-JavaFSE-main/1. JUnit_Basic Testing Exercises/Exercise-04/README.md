# Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures, Setup and Teardown Methods

## Scenario
You need to organize your tests using the Arrange-Act-Assert (AAA) pattern and use setup and teardown methods.

## Steps
1. Write tests using the AAA pattern.
2. Use `@Before` and `@After` annotations for setup and teardown methods.

## Solution Code

```java
import org.junit.*;
import static org.junit.Assert.*;

public class AAAPatternTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        // Arrange — shared setup before each test
        calculator = new Calculator();
        System.out.println("@Before: Calculator initialized");
    }

    @After
    public void tearDown() {
        // Teardown after each test
        calculator = null;
        System.out.println("@After: Calculator cleared");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 10, b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10, b = 5;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(5, result);
    }
}
```

## Output
```
@Before: Calculator initialized
@After: Calculator cleared
@Before: Calculator initialized
@After: Calculator cleared
Tests run: 2, Failures: 0, Errors: 0
```
