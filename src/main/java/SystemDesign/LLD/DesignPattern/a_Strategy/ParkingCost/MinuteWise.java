package SystemDesign.LLD.DesignPattern.a_Strategy.ParkingCost;

public class MinuteWise implements Cost{
    // Rs 0.5 per minute
    @Override
    public double calculateCost(int minute, double costPerMinute) {
        return minute*(costPerMinute);
    }
}
