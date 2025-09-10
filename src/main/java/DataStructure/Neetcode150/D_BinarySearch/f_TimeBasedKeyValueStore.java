package DataStructure.Neetcode150.D_BinarySearch;

import java.util.*;

public class f_TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo","bar",1);
        System.out.println(timeMap.get("foo",1));
        System.out.println(timeMap.get("foo",3));
        timeMap.set("foo","bar2",4);
        System.out.println(timeMap.get("foo",4));
        System.out.println(timeMap.get("foo",5));
    }
}
class TimeMap {
    Map<String, List<ValTime>> map = null;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key))
            map.get(key).add(new ValTime(value, timestamp));
        else  {
            var list = new ArrayList<ValTime>();
            list.add(new ValTime(value, timestamp));
            map.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            var list = map.get(key);
            Collections.sort(list);
            int index = Collections.binarySearch(list, new ValTime("", timestamp));
            if(index>=0) {
                return list.get(index).value;
            } else {
                index = -index-1;
                if(index>0) {
                    return list.get(index-1).value;
                }
            }
        }
        return "";
    }
}

class ValTime implements Comparable<ValTime>{
    String value;
    int timestamp;

    public ValTime(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ValTime valTime = (ValTime) o;
        return getTimestamp() == valTime.getTimestamp() && Objects.equals(getValue(), valTime.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getTimestamp());
    }

    @Override
    public int compareTo(ValTime o) {
        return Integer.compare(this.timestamp, o.timestamp);
    }
}