public class PaymentContext {
    private PaymentStrategy pmtst;

    public void setPaymentStrategy(PaymentStrategy pmtst){
        this.pmtst=pmtst;
    }

    public void pay(double amount){
        if(pmtst==null){
            System.out.println("No payment strategy selected");
        }
        else{
            pmtst.pay(amount);
        }
    }
}
