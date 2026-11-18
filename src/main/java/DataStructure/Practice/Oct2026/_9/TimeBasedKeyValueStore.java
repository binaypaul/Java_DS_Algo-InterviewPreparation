package DataStructure.Practice.Oct2026._9;

import java.util.*;
import lombok.*;

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeBasedKeyValueStore timeBasedKeyValueStore = new TimeBasedKeyValueStore();
        TimeMap tm = new TimeMap();
        tm.set("foo", "bar", 1);
        System.out.println(tm.get("foo", 1));   // "bar"
        System.out.println(tm.get("foo", 3));   // "bar" (largest timestamp_prev <= 3 is 1)
        tm.set("foo", "bar2", 4);
        System.out.println(tm.get("foo", 4));   // "bar2"
        System.out.println(tm.get("foo", 5));   // "bar2"
        System.out.println(tm.get("foo", 0));   // "" (no timestamp <= 0)
    }
    static class TimeMap {
        HashMap<String, List<TimeVal>> lookUpMap = null;

        public TimeMap() {
            lookUpMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            lookUpMap.computeIfAbsent(key, k-> new ArrayList<>()).add(new TimeVal(timestamp, value));
        }

        public String get(String key, int timestamp) {
            var timeValList = lookUpMap.get(key);
            if(timeValList==null) {
                return "";
            } else {
                var idx = Collections.binarySearch(timeValList, new TimeVal(timestamp,""), Comparator.comparing(TimeVal::getTime));
                if(idx<0) {
                    idx=(idx+2);
                    if(idx==1) return "";
                    idx*=-1;
                }
                return timeValList.get(idx).getVal();
            }
        }
    }
    @Data
    @AllArgsConstructor
    static class TimeVal {
        Integer time;
        String val;
    }
}

//1,2,5
//0,1,2 //-3