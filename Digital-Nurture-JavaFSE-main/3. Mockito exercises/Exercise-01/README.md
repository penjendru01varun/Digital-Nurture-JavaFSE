# Exercise 1: Mocking and Stubbing

## Scenario
You need to test a service that depends on an external API. Use Mockito to mock the external API and stub its methods.

## Steps
1. Create a mock object for the external API.
2. Stub the methods to return predefined values.
3. Write a test case that uses the mock object.

## Solution Code

```java
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Arrange: Create mock and stub
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        // Act
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Assert
        assertEquals("Mock Data", result);
    }
}
```

## Output
```
Tests run: 1, Failures: 0 — Mock returned "Mock Data" as expected.
```
