package SystemDesign.LLD.DesignPattern.b_Observer.observables;

import SystemDesign.LLD.DesignPattern.b_Observer.observers.NotificationObserver;

public interface StocksObservable {
    int getStocks();
    void addStocks(int stocks);
    boolean add(NotificationObserver observer);
    boolean remove(NotificationObserver observer);
    void notifyAllObservers();
}
