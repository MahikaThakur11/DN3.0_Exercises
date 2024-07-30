public abstract class NotifierDecorator implements Notifier {
    protected Notifier Notifier1;

    public NotifierDecorator(Notifier notifier) {
        this.Notifier1 = notifier;
    }

    @Override
    public void send(String message) {
        Notifier1.send(message);
    }
}
