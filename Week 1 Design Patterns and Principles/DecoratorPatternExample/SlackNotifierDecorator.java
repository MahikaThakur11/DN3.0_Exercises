public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier){
        super(notifier);
    }

    @Override
    public void send(String message){
        super.send(message);
        Slacksms(message);
    }
    
    private void Slacksms(String message){
        System.out.println("Sending Slack message: "+message);
    }
}
