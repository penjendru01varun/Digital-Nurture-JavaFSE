# Exercise 4: Implementing the Adapter Pattern

## Objective
Develop a payment processing system that needs to integrate with multiple third-party payment gateways with different interfaces using the Adapter Pattern.

## Technologies Used
- Java 17

## Files Included
- `PaymentProcessor.java`: The target interface that the system expects to use.
- `StripeGateway.java`, `PayPalGateway.java`: Adaptee classes representing third-party payment gateways with their own specific methods.
- `StripeAdapter.java`, `PayPalAdapter.java`: Adapter classes that implement `PaymentProcessor` and translate calls to the respective gateways.
- `TestAdapter.java`: The test class demonstrating the use of different payment gateways through the adapter.

## Output Screenshot
```text
Processing payment of $150.0 through Stripe.
Sending payment of $200.0 using PayPal.
```
