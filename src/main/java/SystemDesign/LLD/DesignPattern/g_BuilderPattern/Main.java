package SystemDesign.LLD.DesignPattern.g_BuilderPattern;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("intel", 100, 200);

        System.out.println(computer);

        computer = computer.toBuilder()
                .setStorage(300)
                .build();
        System.out.println(computer);
    }
}
