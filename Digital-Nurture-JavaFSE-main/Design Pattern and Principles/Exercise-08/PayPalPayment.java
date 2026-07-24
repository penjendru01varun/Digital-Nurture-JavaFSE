public class PayPalPayment implements PaymentStrategy {
    private String emailId;

    public PayPalPayment(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid using PayPal (" + emailId + ")");
    }
}
