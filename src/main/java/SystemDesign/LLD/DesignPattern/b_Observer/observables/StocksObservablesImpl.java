package SystemDesign.LLD.DesignPattern.b_Observer.observables;

import SystemDesign.LLD.DesignPattern.b_Observer.observers.NotificationObserver;

import java.util.HashSet;
import java.util.Set;

public class StocksObservablesImpl implements StocksObservable{
    int stocks;
    String itemType;
    Set<NotificationObserver> observers = null;

    public StocksObservablesImpl(String itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getStocks() {
        return this.stocks;
    }

    @Override
    public void addStocks(int stocks) {
        this.stocks=stocks;
        notifyAllObservers();
    }

    @Override
    public boolean add(NotificationObserver observer) {
        if(null == observers) {
            observers = new HashSet<>();
        }
        return this.observers.add(observer);
    }

    @Override
    public boolean remove(NotificationObserver observer) {
        if(null == observers) return false;
        return this.observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for(NotificationObserver observer : this.observers) {
            observer.update(this.stocks, this.itemType);
        }
    }
}
