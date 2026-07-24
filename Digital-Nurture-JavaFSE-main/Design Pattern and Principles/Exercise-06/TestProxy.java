public class TestProxy {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("--- First call (image1) ---");
        image1.display();

        System.out.println("\n--- Second call (image1) ---");
        image1.display();

        System.out.println("\n--- First call (image2) ---");
        image2.display();
    }
}
