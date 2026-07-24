# Exercise 3: Assertions in JUnit

## Scenario
You need to use different assertions in JUnit to validate your test results.

## Steps
1. Write tests using various JUnit assertions.

## Solution Code

```java
import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);

        // Assert true
        assertTrue(5 > 3);

        // Assert false
        assertFalse(5 < 3);

        // Assert null
        assertNull(null);

        // Assert not null
        assertNotNull(new Object());
    }
}
```

## Output
```
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
```
