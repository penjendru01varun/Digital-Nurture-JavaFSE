public class MobileApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("MobileApp Notification -> Stock: " + stockName + " is now $" + price);
    }
}
