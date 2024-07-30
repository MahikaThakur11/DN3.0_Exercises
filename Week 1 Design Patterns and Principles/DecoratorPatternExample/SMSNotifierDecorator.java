public class SMSNotifierDecorator extends NotifierDecorator{
    public SMSNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        super.send(message);
        SMSsender(message);
    }

    private void SMSsender(String message){
        System.out.println("Sending SMS: "+message);
    }
}
