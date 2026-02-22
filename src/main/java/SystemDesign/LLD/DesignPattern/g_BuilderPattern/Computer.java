package SystemDesign.LLD.DesignPattern.g_BuilderPattern;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer implements Builder {
    private String processor;
    private int memory;
    private int storage;

    @Override
    public ComputerBuilder toBuilder() {
        return new ComputerBuilder(this);
    }
}
