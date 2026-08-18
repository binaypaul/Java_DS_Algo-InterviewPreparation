import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        Test m = new Test();
        m.recordTemp(-200); //-200,-100,-100,0,0,100,200
        m.recordTemp(-100);
        m.recordTemp(0);
        m.recordTemp(-100);
        m.recordTemp(0);
        m.recordTemp(100);
        m.recordTemp(200);
        m.recordTemp(201);
        m.recordTemp(202);
        m.recordTemp(203);
        System.out.println(m.findMedian());
    }

    Map<Integer, Integer> map = new TreeMap();
    int count = 0;

    private void recordTemp(int temp) {
        map.put(temp, map.getOrDefault(temp, 0)+1);
        count++;
    }

    private double findMedian() {
        if(count%2==0) {
            return (double) ((findVal(count/2+1)+findVal(count/2))/2);
        } else {
            return (double) findVal(count/2+1);
        }
    }

    private int findVal(int position) {
        var set = map.entrySet().stream().toList();
        var posCo = 0;

        for (var e : set) {
            posCo += e.getValue();
            if(posCo >= position) {
                return e.getKey();
            }
        }
        return 0;
    }
}