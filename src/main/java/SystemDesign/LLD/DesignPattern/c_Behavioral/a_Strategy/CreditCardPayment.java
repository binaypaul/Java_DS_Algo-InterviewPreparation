package SystemDesign.LLD.DesignPattern.c_Behavioral.a_Strategy;

public class CreditCardPayment implements PaymentStrategy{
    private long cardNumber;

    public CreditCardPayment(long cardNumber) {
        this.cardNumber = cardNumber;
    }


    @Override
    public boolean pay(double amount) {
        // Credit card processing logic
        System.out.println("Paid " + amount + " with credit card");
        return true;
    }
}
