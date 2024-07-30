public class CreditCardPayment implements PaymentStrategy{
    private String number;
    private String user;
    private String cvv;
    private String expdate;

    public CreditCardPayment(String number,String user, String cvv, String expdate){
        this.number=number;
        this.user=user;
        this.cvv=cvv;
        this.expdate=expdate;
    }

    @Override
    public void pay(double amount){
        System.out.println("Transaction of Rs. "+amount+" using Credit Card.");
    }
}
