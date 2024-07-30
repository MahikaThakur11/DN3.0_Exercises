public class ProxyPatternTest {
    public static void main(String[] args) {
        Image im1 = new ProxyImage("img1test.jpg");
        Image im2 = new ProxyImage("img2test.jpg");

        im1.display(); 
        System.out.println("");
         
        System.out.println("");

        im2.display();
        System.out.println(""); 
    }
}
