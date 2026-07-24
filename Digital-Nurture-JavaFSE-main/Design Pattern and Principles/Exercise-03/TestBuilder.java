public class TestBuilder {
    public static void main(String[] args) {
        Computer gamingPc = new Computer.Builder()
                .setCpu("Intel Core i9")
                .setRam("32GB")
                .setStorage("2TB NVMe SSD")
                .build();

        Computer officePc = new Computer.Builder()
                .setCpu("Intel Core i5")
                .setRam("8GB")
                .setStorage("512GB SSD")
                .build();

        System.out.println("Gaming PC: " + gamingPc);
        System.out.println("Office PC: " + officePc);
    }
}
