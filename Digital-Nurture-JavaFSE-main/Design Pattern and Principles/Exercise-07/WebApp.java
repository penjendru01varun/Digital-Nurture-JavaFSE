public class WebApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("WebApp Dashboard -> Stock: " + stockName + " is now $" + price);
    }
}
