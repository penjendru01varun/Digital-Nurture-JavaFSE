# Exercise 8: Implementing the Strategy Pattern

## Objective
Develop a payment system where different payment methods (e.g., Credit Card, PayPal) can be selected at runtime using the Strategy Pattern.

## Technologies Used
- Java 17

## Files Included
- `PaymentStrategy.java`: Strategy interface for processing payments.
- `CreditCardPayment.java`, `PayPalPayment.java`: Concrete strategies implementing different payment methods.
- `PaymentContext.java`: Context class that holds a reference to a `PaymentStrategy` and executes it.
- `TestStrategy.java`: Test class demonstrating selecting and using different payment strategies dynamically.

## Output Screenshot
```text
250.0 paid with credit/debit card (1234-5678-9012-3456)
100.0 paid using PayPal (john.doe@example.com)
```
