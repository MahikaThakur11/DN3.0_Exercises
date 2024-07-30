public class BuilderPatternTest {
    public static void main(String[] args) {
        Computer gamingPC=new Computer.ComputerBuilder("Intel I9", "32GB", "1TB SSD").build();

        Computer officePC=new Computer.ComputerBuilder("Intel i5", "16GB", "512GB SSD").build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}
