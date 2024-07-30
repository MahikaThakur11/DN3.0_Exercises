public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1=Logger.getInstance();
        Logger logger2=Logger.getInstance();

        if(logger1==logger2){
            System.out.println("Singleton pattern verified: Both logger1 and logger2 refer to the same instance.");
        }
        else{
            System.out.println("Singleton pattern failed: logger1 and logger2 refer to the different instance.");
        }

        logger1.log("Test logger1");
        logger2.log("This is another test log message.");
    }
}
