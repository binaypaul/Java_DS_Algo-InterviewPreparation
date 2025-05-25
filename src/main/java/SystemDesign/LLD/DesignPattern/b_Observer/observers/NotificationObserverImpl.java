package SystemDesign.LLD.DesignPattern.b_Observer.observers;

public class NotificationObserverImpl implements NotificationObserver {
    private final String notificationType;

    public NotificationObserverImpl(String notificationType) {
        this.notificationType = notificationType;
    }

    @Override
    public void update(int stocks, String item) {
        System.out.println(this.notificationType + " notification of " + stocks + " " + item + " is sent.");
    }
}