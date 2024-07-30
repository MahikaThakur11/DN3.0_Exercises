import java.util.HashMap;
public class inventory {
    private HashMap<String,product> products;

    public inventory(){
        this.products=new HashMap<>();
    }

    public void addProduct(product p1){
        if(products.containsKey(p1.getproductId())){
            System.out.println("Product ID exits.");
        }
        else{
            products.put(p1.getproductId(), p1);
            System.out.println("Product "+p1.getProductName()+" added.");
        }
    }

    public void updateProduct(String productId,String productName,Integer quantity,Double price){
        product p1=products.get(productId);
        if(p1!=null){
            if(productName!=null){
                p1.setProductName(productName);
            }
            if(quantity!=null){
                p1.setQuantity(quantity);
            }
            if(price!=null){
                p1.setPrice(price);
            }
            System.out.println("Product " + productId + " updated.");
        }
        else{
            System.out.println("ProductID not found.");
        }
    }

    public void deleteProduct(String productId){
        if(products.containsKey(productId)){
            products.remove(productId);
            System.out.println("Product "+productId+" deleted.");
        }
        else{
            System.out.println("Product Id not found");
        }
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "products=" + products +
                '}';
    }
}
