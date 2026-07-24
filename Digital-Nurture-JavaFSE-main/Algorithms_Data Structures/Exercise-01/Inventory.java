import java.util.HashMap;

public class Inventory {
    private HashMap<String, ProductEx1> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(ProductEx1 product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists.");
        } else {
            products.put(product.getProductId(), product);
            System.out.println("Product added: " + product.getProductName());
        }
    }

    public void updateProduct(ProductEx1 product) {
        if (products.containsKey(product.getProductId())) {
            products.put(product.getProductId(), product);
            System.out.println("Product updated: " + product.getProductName());
        } else {
            System.out.println("Product with ID " + product.getProductId() + " not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            ProductEx1 removed = products.remove(productId);
            System.out.println("Product deleted: " + removed.getProductName());
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void displayInventory() {
        System.out.println("--- Current Inventory ---");
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (ProductEx1 p : products.values()) {
                System.out.println(p.toString());
            }
        }
        System.out.println("-------------------------");
    }
}
