public class SearchUtil {
    
    // Linear Search: O(N) Time Complexity
    public static ProductEx2 linearSearch(ProductEx2[] products, String targetName) {
        for (ProductEx2 product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search: O(log N) Time Complexity (Requires sorted array)
    public static ProductEx2 binarySearch(ProductEx2[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
