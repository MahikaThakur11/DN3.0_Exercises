public class ObserverPatternTest {
        public static void main(String[] args) {
        StockMarket sm = new StockMarket();

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp1 = new WebApp("WebApp1");

        sm.registerObserver(mobileApp1);
        sm.registerObserver(mobileApp2);
        sm.registerObserver(webApp1);

        sm.setStockPrice(67.00);
        sm.setStockPrice(105.50);

        sm.deregisterObserver(mobileApp2);
        sm.setStockPrice(110.75);
    }
}
