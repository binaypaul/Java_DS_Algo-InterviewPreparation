package SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost;

public interface Cost {
    double calculateCost(int unit, double costPerMinute);
}
