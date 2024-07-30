public class Computer{
    private String CPU;
    private String RAM;
    private String storage;

    private Computer(ComputerBuilder builder){
        this.CPU=builder.CPU;
        this.RAM=builder.RAM;
        this.storage=builder.storage;
    }

    public String getCPU(){
        return CPU;
    }

    public String getRAM(){
        return RAM;
    }

    public String getStorage(){
        return storage;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + "]";
    }

    public static class ComputerBuilder{
        private String CPU;
        private String RAM;
        private String storage;

        public ComputerBuilder(String CPU,String RAM,String storage){
            this.CPU=CPU;
            this.RAM=RAM;
            this.storage=storage;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}