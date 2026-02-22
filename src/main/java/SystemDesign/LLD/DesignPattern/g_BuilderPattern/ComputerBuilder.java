package SystemDesign.LLD.DesignPattern.g_BuilderPattern;

public class ComputerBuilder {
    private final Computer computer;
    public ComputerBuilder(Computer computer) {
        this.computer = computer;
    }

    public ComputerBuilder setProcessor(String processor) {
        computer.setProcessor(processor);
        return this;
    }
    public ComputerBuilder setMemory(int memory) {
        computer.setMemory(memory);
        return this;
    }
    public ComputerBuilder setStorage(int storage) {
        computer.setStorage(storage);
        return this;
    }
    public Computer build() {
        return computer;
    }
}