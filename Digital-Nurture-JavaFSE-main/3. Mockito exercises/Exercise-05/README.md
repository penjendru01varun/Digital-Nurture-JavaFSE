# Exercise 5: Mocking and Stubbing with Multiple Returns

## Scenario
You need to test a service that depends on an external API with multiple return values on consecutive calls.

## Steps
1. Create a mock object for the external API.
2. Stub the methods to return different values on consecutive calls.
3. Write a test case that uses the mock object.

## Solution Code

```java
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MultipleReturnsTest {

    @Test
    public void testMultipleReturnValues() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub to return different values on consecutive calls
        when(mockApi.getData())
            .thenReturn("First Call")
            .thenReturn("Second Call")
            .thenReturn("Third Call");

        assertEquals("First Call",  mockApi.getData());
        assertEquals("Second Call", mockApi.getData());
        assertEquals("Third Call",  mockApi.getData());
        // Subsequent calls return the last stubbed value
        assertEquals("Third Call",  mockApi.getData());
    }
}
```

## Output
```
Tests run: 1, Failures: 0 — Consecutive return values verified.
```
