public class CPTest {
    public static void main(String[] args) {
        Light lg=new Light();

        Command lON=new LightOnCommand(lg);
        Command lOFF=new LightOffCommand(lg);

        RemoteControl rc = new RemoteControl();

        rc.setCommand(lON);
        rc.onclick();

        rc.setCommand(lOFF);
        rc.onclick();
    }
}