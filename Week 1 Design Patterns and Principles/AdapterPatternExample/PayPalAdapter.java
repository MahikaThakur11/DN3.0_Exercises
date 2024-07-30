public class PayPalAdapter implements PaymentProcessor{
    private PayPal payPalGateway;

    public PayPalAdapter(PayPal payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.makePayment(amount);
    }
}
