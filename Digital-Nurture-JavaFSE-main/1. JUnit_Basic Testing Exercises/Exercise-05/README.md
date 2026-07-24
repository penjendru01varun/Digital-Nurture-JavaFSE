# Exercise 5: Test Fixtures, Setup and Teardown Methods

## Objective
Use `@BeforeEach`, `@AfterEach`, `@BeforeAll`, and `@AfterAll` lifecycle annotations to manage shared test state and resources efficiently.

## Key Concepts
- `@BeforeEach` — runs before every individual test method.
- `@AfterEach` — runs after every individual test method.
- `@BeforeAll` — runs once before all tests in the class (must be `static`).
- `@AfterAll` — runs once after all tests in the class (must be `static`).

## Solution Code

```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SetupTeardownTest {

    @BeforeAll
    static void initAll() {
        System.out.println("@BeforeAll — runs once before all tests");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach — runs before each test");
    }

    @Test
    void testOne() {
        assertTrue(1 + 1 == 2, "Basic math should work");
    }

    @Test
    void testTwo() {
        assertNotNull("Hello", "String should not be null");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach — runs after each test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll — runs once after all tests");
    }
}
```

## Output
```
@BeforeAll — runs once before all tests
@BeforeEach — runs before each test
@AfterEach — runs after each test
@BeforeEach — runs before each test
@AfterEach — runs after each test
@AfterAll — runs once after all tests
```
