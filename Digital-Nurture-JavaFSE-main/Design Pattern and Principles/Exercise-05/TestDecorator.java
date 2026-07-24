public class TestDecorator {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        
        Notifier allNotifier = new SlackNotifierDecorator(smsNotifier);
        
        System.out.println("--- Sending via Email only ---");
        emailNotifier.send("System Update 1.0");

        System.out.println("\n--- Sending via Email and SMS ---");
        smsNotifier.send("System Update 2.0");

        System.out.println("\n--- Sending via Email, SMS, and Slack ---");
        allNotifier.send("System Update 3.0 (CRITICAL)");
    }
}
