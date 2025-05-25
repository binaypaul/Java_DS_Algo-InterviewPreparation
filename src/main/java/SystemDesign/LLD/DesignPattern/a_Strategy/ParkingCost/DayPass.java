package SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost;

public class DayPass implements Cost {
    // Rs 0.5 per minute
    @Override
    public double calculateCost(int day, double costPerMinute) {
        return day*(24*60)*(costPerMinute);
    }
}
