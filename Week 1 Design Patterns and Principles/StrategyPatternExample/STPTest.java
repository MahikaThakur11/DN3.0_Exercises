public class STPTest {
    public static void main(String[] args) {
        PaymentContext pc=new PaymentContext();

        PaymentStrategy ccPayment=new CreditCardPayment("0111 1110 9902 2909 ", "John", "630", "09/2027");
        pc.setPaymentStrategy(ccPayment);
        pc.pay(1925.56);

        PaymentStrategy ppPayment=new PayPalPayment("JaneDoe@gmail.com", "payove11");
        pc.setPaymentStrategy(ppPayment);
        pc.pay(500.125);
    }
}
