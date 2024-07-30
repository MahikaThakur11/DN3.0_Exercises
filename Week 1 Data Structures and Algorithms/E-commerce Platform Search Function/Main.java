public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("001", "Laptop", "Electronics"),
            new Product("002", "Smartphone", "Electronics"),
            new Product("003", "Tablet", "Electronics"),
            new Product("004", "Headphones", "Accessories"),
            new Product("005", "Charger", "Accessories")
        };

        // Linear search example
        Product result = Search.linearSearch(products, "Tablet");
        System.out.println(result != null ? "Product found: " + result : "Product not found");

        // Binary search example
        result = Search.binarySearch(products, "Tablet");
        System.out.println(result != null ? "Product found: " + result : "Product not found");
    }
}
