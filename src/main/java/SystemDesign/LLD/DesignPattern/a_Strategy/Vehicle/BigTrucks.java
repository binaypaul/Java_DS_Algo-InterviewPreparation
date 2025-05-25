package SystemDesign.LLD.DesignPattern.a_Strategy.Vehicle;

import SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost.DayPass;

//payment always by day pass
public class BigTrucks extends Vehicle{
    public BigTrucks() {
        super(new DayPass());
    }
}
