package SystemDesign.LLD.DesignPattern.c_Behavioral.a_Strategy;

public class PaypalPayment implements PaymentStrategy{
    private String username;

    public PaypalPayment(String username) {
        this.username = username;
    }


    @Override
    public boolean pay(double amount) {
        // Paypal processing logic
        System.out.println("Paid " + amount + " with paypal");
        return true;
    }
}
