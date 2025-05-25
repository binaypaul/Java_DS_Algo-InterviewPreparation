package SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost;

public class HourWise implements Cost {
    // Rs 0.5 per minute
    @Override
    public double calculateCost(int hour, double costPerMinute) {
        return hour*(60)*(costPerMinute);
    }
}
