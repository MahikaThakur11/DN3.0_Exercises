public class RazorPayAdapter implements PaymentProcessor{
    private RazorPay RazorPayGateway;

    public RazorPayAdapter(RazorPay RazorPayGateway) {
        this.RazorPayGateway = RazorPayGateway;
    }

    @Override
    public void processPayment(double amount) {
        RazorPayGateway.makePayment(amount);
    }
}
