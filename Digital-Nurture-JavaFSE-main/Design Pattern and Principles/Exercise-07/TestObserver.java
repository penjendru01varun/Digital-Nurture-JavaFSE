public class TestObserver {
    public static void main(String[] args) {
        StockMarket appleStock = new StockMarket("AAPL", 150.0);

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        appleStock.register(mobileApp);
        appleStock.register(webApp);

        System.out.println("--- First price update ---");
        appleStock.setPrice(155.0);

        appleStock.deregister(mobileApp);

        System.out.println("\n--- Second price update ---");
        appleStock.setPrice(160.0);
    }
}
