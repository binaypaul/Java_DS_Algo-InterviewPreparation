package DataStructure.Practice.Sept2026._29;

import java.util.*;

class StockPrice {
    HashMap<Integer, Integer> timePriceMap = new HashMap<>();
    TreeMap<Integer, HashSet<Integer>> priceTimeSetMap = new TreeMap<>();
    public StockPrice() {

    }
    int cur = -1;
    public void update(int timestamp, int price) {
        if(timePriceMap.containsKey(timestamp)) {
            int oldPrice = timePriceMap.get(timestamp);
            var timeSet = priceTimeSetMap.get(oldPrice);
            if(timeSet.size()>1) {
                timeSet.remove(timestamp);
            } else {
                priceTimeSetMap.remove(oldPrice);
            }
        }
        timePriceMap.put(timestamp, price);
        priceTimeSetMap.computeIfAbsent(price, k-> new HashSet<Integer>()).add(timestamp);
        cur = Math.max(cur, timestamp);
    }

    public int current() {
        if(timePriceMap.isEmpty()) {
            return -1;
        }
        return timePriceMap.get(cur);
    }

    public int maximum() {
        if(timePriceMap.isEmpty()) {
            return -1;
        }
        return priceTimeSetMap.lastKey();
    }

    public int minimum() {
        if(timePriceMap.isEmpty()) {
            return -1;
        }
        return priceTimeSetMap.firstKey();
    }
}
public class StockPriceFluctuation {
    public static void main(String[] args) {
        StockPrice sp = new StockPrice();
        sp.update(1, 10);
        sp.update(2, 5);

        var ret = sp.current();  // 5  (latest timestamp is 2, price 5)
        System.out.println(ret);

        ret = sp.maximum();  // 10 (highest price seen: 10)
        System.out.println(ret);

        sp.update(1, 3);  // correction: timestamp 1's price is now 3, not 10
        ret = sp.maximum();  // 5  (highest price seen is now 5, since 10 was overwritten)
        System.out.println(ret);

        sp.update(4, 2);
        ret = sp.minimum();  // 2  (lowest price seen: 2)
        System.out.println(ret);

        ret = sp.current();  // 2  (latest timestamp is 2, price 5)
        System.out.println(ret);
    }
}
