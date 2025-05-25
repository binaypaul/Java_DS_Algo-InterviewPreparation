package SystemDesign.LLD.DesignPattern.a_Strategy.Vehicle;

import SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost.Cost;

//payment not predefined, can choose day pass, hourwise, minutewise
public class TwoWheeler extends Vehicle{
    public TwoWheeler(Cost cost) {
        super(cost);
    }
}
