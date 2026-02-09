package SystemDesign.LLD.DesignPattern.a_Strategy.Vehicle;

import SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost.HourWise;

//payment predefined, only hourwise cost
public class FourWheeler extends Vehicle{
    public FourWheeler() {
        super(new HourWise());
    }
}
