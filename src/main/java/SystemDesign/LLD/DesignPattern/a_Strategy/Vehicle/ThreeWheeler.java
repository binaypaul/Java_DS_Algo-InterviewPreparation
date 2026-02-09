package SystemDesign.LLD.DesignPattern.a_Strategy.Vehicle;

import SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost.MinuteWise;

//payment predefined, only minutewise cost
public class ThreeWheeler extends Vehicle{
    public ThreeWheeler() {
        super(new MinuteWise());
    }
}
