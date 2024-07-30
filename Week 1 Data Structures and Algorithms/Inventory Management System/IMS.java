public class IMS{
        public static void main(String[] args) {
            inventory inventory = new inventory();
    
            product product1 = new product("001", "Laptop", 10, 999.99);
            product product2 = new product("002", "Smartphone", 50, 499.99);
    
            inventory.addProduct(product1);
            inventory.addProduct(product2);
    
            System.out.println(inventory);
    
            inventory.updateProduct("001", "Gaming Laptop", 5, 1199.99);
            System.out.println(inventory);
    
            inventory.deleteProduct("002");
            System.out.println(inventory);
        }    
}