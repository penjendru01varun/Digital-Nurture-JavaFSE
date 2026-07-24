# Exercise 6: Verifying Interaction Order

## Scenario
You need to ensure that methods are called in a specific order.

## Steps
1. Create a mock object.
2. Call the methods in a specific order.
3. Verify the interaction order using `InOrder`.

## Solution Code

```java
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class InteractionOrderTest {

    @Test
    public void testInteractionOrder() {
        OrderService mockOrder   = mock(OrderService.class);
        PaymentService mockPayment = mock(PaymentService.class);
        NotifyService mockNotify  = mock(NotifyService.class);

        // Act: call in expected order
        mockOrder.placeOrder("Item-A");
        mockPayment.processPayment(100.0);
        mockNotify.sendConfirmation("order@example.com");

        // Verify order was respected
        InOrder inOrder = inOrder(mockOrder, mockPayment, mockNotify);
        inOrder.verify(mockOrder).placeOrder("Item-A");
        inOrder.verify(mockPayment).processPayment(100.0);
        inOrder.verify(mockNotify).sendConfirmation("order@example.com");
    }
}
```

## Output
```
Tests run: 1, Failures: 0 — Interaction order verified.
```
