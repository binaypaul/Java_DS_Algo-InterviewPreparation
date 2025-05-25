package SystemDesign.LLD.DesignPattern.a_Strategy;

import SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost.Cost;
import SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost.HourWise;
import SystemDesign.LLD.DesignPattern.a_Strategy.Vehicle.*;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new BigTrucks();
        System.out.println(vehicle.calculateParkingCost(1, 4));

        System.out.println(new FourWheeler().calculateParkingCost(8, 3));
        System.out.println(new ThreeWheeler().calculateParkingCost(60, 2));
        Cost cost = new HourWise();
        System.out.println(new TwoWheeler(cost).calculateParkingCost(8, 1));
    }
}
