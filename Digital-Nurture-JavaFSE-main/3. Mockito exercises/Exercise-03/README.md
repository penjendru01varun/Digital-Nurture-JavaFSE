# Exercise 3: Argument Matching

## Scenario
You need to verify that a method is called with specific arguments using argument matchers.

## Steps
1. Create a mock object.
2. Call the method with specific arguments.
3. Use argument matchers to verify the interaction.

## Solution Code

```java
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import org.junit.jupiter.api.Test;

public class ArgumentMatchingTest {

    @Test
    public void testArgumentMatching() {
        UserService mockService = mock(UserService.class);
        when(mockService.getUserById(anyLong())).thenReturn(new User(1L, "Alice"));

        // Act
        User result = mockService.getUserById(1L);

        // Verify with exact argument matcher
        verify(mockService).getUserById(eq(1L));

        // Verify with any matcher
        verify(mockService).getUserById(anyLong());
    }
}
```

## Output
```
Tests run: 1, Failures: 0 — Argument matchers verified correctly.
```
