package SystemDesign.LLD.DesignPattern.c_Behavioral.b_Observer;

import SystemDesign.LLD.DesignPattern.c_Behavioral.b_Observer.observables.StocksObservable;
import SystemDesign.LLD.DesignPattern.c_Behavioral.b_Observer.observables.StocksObservablesImpl;
import SystemDesign.LLD.DesignPattern.c_Behavioral.b_Observer.observers.NotificationObserver;
import SystemDesign.LLD.DesignPattern.c_Behavioral.b_Observer.observers.NotificationObserverImpl;

public class Usage {
    public static void main(String[] args) {
        StocksObservable iphoneObservable = new StocksObservablesImpl("iPhone");
        StocksObservable macbookObservable = new StocksObservablesImpl("Macbook");

        NotificationObserver smsObserver = new NotificationObserverImpl("SMS");
        NotificationObserver emailObserver = new NotificationObserverImpl("E-Mail");

        iphoneObservable.add(smsObserver);
        iphoneObservable.add(emailObserver);

        macbookObservable.add(smsObserver);
        macbookObservable.add(emailObserver);

        iphoneObservable.addStocks(1);
        iphoneObservable.remove(smsObserver);
        iphoneObservable.addStocks(2);

        System.out.println();

        macbookObservable.addStocks(3);
        macbookObservable.remove(smsObserver);
        macbookObservable.addStocks(4);
    }
}
