# Exercise 4: Handling Void Methods

## Scenario
You need to test a void method that performs some action using Mockito's `doNothing()` and `doThrow()`.

## Steps
1. Create a mock object.
2. Stub the void method.
3. Verify the interaction.

## Solution Code

```java
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class VoidMethodTest {

    @Test
    public void testVoidMethod() {
        NotificationService mockNotif = mock(NotificationService.class);

        // Stub void method to do nothing (default behaviour, but explicit)
        doNothing().when(mockNotif).sendEmail(anyString());

        // Act
        mockNotif.sendEmail("user@example.com");

        // Verify it was called
        verify(mockNotif).sendEmail("user@example.com");
    }

    @Test
    public void testVoidMethodThrowsException() {
        NotificationService mockNotif = mock(NotificationService.class);

        // Stub void method to throw exception
        doThrow(new RuntimeException("Email service down"))
            .when(mockNotif).sendEmail(anyString());

        // Assert exception is thrown
        org.junit.jupiter.api.Assertions.assertThrows(
            RuntimeException.class,
            () -> mockNotif.sendEmail("user@example.com")
        );
    }
}
```

## Output
```
Tests run: 2, Failures: 0 — Void method interaction verified.
```
