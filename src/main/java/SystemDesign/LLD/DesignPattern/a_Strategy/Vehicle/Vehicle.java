package SystemDesign.LLD.DesignPattern.a_Strategy.Vehicle;

import SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost.Cost;

public class Vehicle {
    private Cost cost;

    public Vehicle(Cost cost) {
        this.cost = cost;
    }

    public double calculateParkingCost(int unit, int costPerMinute) {
        return cost.calculateCost(unit, costPerMinute);
    }
}
