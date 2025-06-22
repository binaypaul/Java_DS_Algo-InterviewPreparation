package SystemDesign.LLD.DesignPattern.a_Strategy;

import SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost.Cost;
import SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost.HourWise;
import SystemDesign.LLD.DesignPattern.a_Strategy.Vehicle.*;

public class Main {
    public static void main(String[] args) {
        Cost cost = new HourWise();
        Vehicle vehicle = new TwoWheeler(cost);
        System.out.println(vehicle.calculateParkingCost(8, 1));

        System.out.println(new BigTrucks().calculateParkingCost(1, 4));
        System.out.println(new FourWheeler().calculateParkingCost(8, 3));
        System.out.println(new ThreeWheeler().calculateParkingCost(60, 2));
    }
}
