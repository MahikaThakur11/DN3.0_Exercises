public class MobileApp implements Observer {
    private String app;

    public MobileApp(String appName){
        this.app=appName;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println(app + " received stock price update: " + stockPrice);
    }
}
