public class MainEx1 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        ProductEx1 p1 = new ProductEx1("P001", "Laptop", 10, 1200.50);
        ProductEx1 p2 = new ProductEx1("P002", "Smartphone", 25, 800.00);
        ProductEx1 p3 = new ProductEx1("P003", "Tablet", 15, 300.00);

        System.out.println("--- Adding Products ---");
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);
        
        inventory.displayInventory();

        System.out.println("--- Updating Product ---");
        p2.setQuantity(30);
        inventory.updateProduct(p2);

        inventory.displayInventory();

        System.out.println("--- Deleting Product ---");
        inventory.deleteProduct("P001");

        inventory.displayInventory();
    }
}
