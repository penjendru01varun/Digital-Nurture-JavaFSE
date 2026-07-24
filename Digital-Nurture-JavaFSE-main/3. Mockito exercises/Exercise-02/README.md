# Exercise 2: Verifying Interactions

## Scenario
You need to ensure that a method is called with specific arguments.

## Steps
1. Create a mock object.
2. Call the method with specific arguments.
3. Verify the interaction using `verify()`.

## Solution Code

```java
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Act
        service.fetchData();

        // Assert: Verify the mock's getData() was called exactly once
        verify(mockApi).getData();
        verify(mockApi, times(1)).getData();
    }
}
```

## Output
```
Tests run: 1, Failures: 0 — Interaction verified: getData() called once.
```
