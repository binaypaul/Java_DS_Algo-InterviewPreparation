package SystemDesign.LLD.DesignPattern.c_Behavioral.a_Strategy;

public class PlaceOrder {
    private PaymentStrategy paymentStrategy;


    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean checkout(double amount) {
        return paymentStrategy.pay(amount);
    }
}
