public class TestStrategy {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCard = new CreditCardPayment("John Doe", "1234-5678-9012-3456");
        context.setPaymentStrategy(creditCard);
        context.executePayment(250.0);

        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com");
        context.setPaymentStrategy(payPal);
        context.executePayment(100.0);
    }
}
