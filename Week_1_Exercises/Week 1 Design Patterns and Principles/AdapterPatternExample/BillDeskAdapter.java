public class BillDeskAdapter implements PaymentProcessor{
        private BillDesk BillDeskGateway;
    
        public BillDeskAdapter(BillDesk BillDeskGateway) {
            this.BillDeskGateway = BillDeskGateway;
        }
    
        @Override
        public void processPayment(double amount) {
            BillDeskGateway.sendPayment(amount);
        }
}