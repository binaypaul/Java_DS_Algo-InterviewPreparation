package SystemDesign.LLD.DesignPattern.a_Strategy.Vehicle;

import SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost.HourWise;

//payment always hourwise
public class FourWheeler extends Vehicle{
    public FourWheeler() {
        super(new HourWise());
    }
}
