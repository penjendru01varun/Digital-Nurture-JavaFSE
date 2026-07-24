public class MainEx3 {
    public static void main(String[] args) {
        Order[] ordersForBubble = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 15.00),
            new Order("O003", "Charlie", 99.99),
            new Order("O004", "Diana", 500.00),
            new Order("O005", "Eve", 120.00)
        };

        System.out.println("--- Before Bubble Sort ---");
        for (Order o : ordersForBubble) {
            System.out.println(o);
        }

        SortUtil.bubbleSort(ordersForBubble);

        System.out.println("\n--- After Bubble Sort ---");
        for (Order o : ordersForBubble) {
            System.out.println(o);
        }

        Order[] ordersForQuick = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 15.00),
            new Order("O003", "Charlie", 99.99),
            new Order("O004", "Diana", 500.00),
            new Order("O005", "Eve", 120.00)
        };

        System.out.println("\n--- Before Quick Sort ---");
        for (Order o : ordersForQuick) {
            System.out.println(o);
        }

        SortUtil.quickSort(ordersForQuick, 0, ordersForQuick.length - 1);

        System.out.println("\n--- After Quick Sort ---");
        for (Order o : ordersForQuick) {
            System.out.println(o);
        }
    }
}
