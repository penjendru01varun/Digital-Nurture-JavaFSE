import java.util.Arrays;
import java.util.Comparator;

public class MainEx2 {
    public static void main(String[] args) {
        ProductEx2[] products = {
            new ProductEx2("P101", "Laptop", "Electronics"),
            new ProductEx2("P102", "Smartphone", "Electronics"),
            new ProductEx2("P103", "Tablet", "Electronics"),
            new ProductEx2("P104", "Headphones", "Accessories"),
            new ProductEx2("P105", "Monitor", "Electronics")
        };

        String targetName = "Tablet";

        // Testing Linear Search
        System.out.println("--- Linear Search ---");
        ProductEx2 foundByLinear = SearchUtil.linearSearch(products, targetName);
        if (foundByLinear != null) {
            System.out.println("Found: " + foundByLinear);
        } else {
            System.out.println("Product not found.");
        }

        // Preparing for Binary Search (Must sort first)
        Arrays.sort(products, new Comparator<ProductEx2>() {
            @Override
            public int compare(ProductEx2 p1, ProductEx2 p2) {
                return p1.getProductName().compareToIgnoreCase(p2.getProductName());
            }
        });

        // Testing Binary Search
        System.out.println("\n--- Binary Search ---");
        ProductEx2 foundByBinary = SearchUtil.binarySearch(products, targetName);
        if (foundByBinary != null) {
            System.out.println("Found: " + foundByBinary);
        } else {
            System.out.println("Product not found.");
        }
    }
}
