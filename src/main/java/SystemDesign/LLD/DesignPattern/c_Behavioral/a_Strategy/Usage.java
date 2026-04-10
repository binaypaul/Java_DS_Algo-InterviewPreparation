package SystemDesign.LLD.DesignPattern.c_Behavioral.a_Strategy;

public class Usage {
    public static void main(String[] args) {
        PlaceOrder placeOrder = new PlaceOrder();

        placeOrder.setPaymentStrategy(new CreditCardPayment(123456789L));
        placeOrder.checkout(10.0);

        placeOrder.setPaymentStrategy(new PaypalPayment("binaypaul"));
        placeOrder.checkout(10.0);
    }
}
