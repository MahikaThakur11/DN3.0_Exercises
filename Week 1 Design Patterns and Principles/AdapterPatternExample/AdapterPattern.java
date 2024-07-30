public class AdapterPattern {
    public static void main(String[] args) {
        PayPal payPalGateway = new PayPal();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        payPalProcessor.processPayment(100.0);

        RazorPay rpg=new RazorPay();
        PaymentProcessor Razorpayprocessor=new RazorPayAdapter(rpg);
        Razorpayprocessor.processPayment(5890.45);

        BillDesk bd=new BillDesk();
        PaymentProcessor BillDeskProcessor=new BillDeskAdapter(bd);
        BillDeskProcessor.processPayment(3210.22);
    }
}
