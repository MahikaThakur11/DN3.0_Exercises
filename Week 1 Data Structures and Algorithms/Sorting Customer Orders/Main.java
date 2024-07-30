public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("001", "Alice", 300.50),
            new Order("002", "Bob", 150.75),
            new Order("003", "Charlie", 200.00),
            new Order("004", "Daisy", 450.00),
            new Order("005", "Eve", 120.25)
        };

        // Sort orders using Bubble Sort
        System.out.println("Sorting using Bubble Sort:");
        BubbleSort.sort(orders);
        printOrders(orders);

        // Reset orders for Quick Sort
        orders = new Order[]{
            new Order("001", "Alice", 300.50),
            new Order("002", "Bob", 150.75),
            new Order("003", "Charlie", 200.00),
            new Order("004", "Daisy", 450.00),
            new Order("005", "Eve", 120.25)
        };

        // Sort orders using Quick Sort
        System.out.println("\nSorting using Quick Sort:");
        QuickSort.sort(orders, 0, orders.length - 1);
        printOrders(orders);
    }

    // Utility method to print orders
    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

