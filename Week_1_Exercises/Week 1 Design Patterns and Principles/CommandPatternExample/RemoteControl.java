public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void onclick() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command assigned to the button.");
        }
    }
}