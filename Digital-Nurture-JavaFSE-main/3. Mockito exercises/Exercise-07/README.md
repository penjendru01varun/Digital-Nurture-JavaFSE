# Exercise 7: Handling Void Methods with Exceptions

## Scenario
You need to test a void method that throws an exception under certain conditions.

## Steps
1. Create a mock object.
2. Stub the void method to throw an exception.
3. Verify the interaction.

## Solution Code

```java
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VoidExceptionTest {

    @Test
    public void testVoidMethodThrowsException() {
        EmailService mockEmail = mock(EmailService.class);

        // Stub void method to throw when called with null
        doThrow(new IllegalArgumentException("Email cannot be null"))
            .when(mockEmail).send(null);

        // Act & Assert
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> mockEmail.send(null)
        );
        assertEquals("Email cannot be null", ex.getMessage());

        // Verify the interaction happened
        verify(mockEmail).send(null);
    }
}
```

## Output
```
Tests run: 1, Failures: 0 — Exception from void method verified.
```
