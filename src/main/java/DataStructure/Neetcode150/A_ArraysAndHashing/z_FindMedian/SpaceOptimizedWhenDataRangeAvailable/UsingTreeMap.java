package DataStructure.Neetcode150.A_ArraysAndHashing.z_FindMedian.SpaceOptimizedWhenDataRangeAvailable;

import java.util.*;

//Counting Sort / Bucket Search
//Best for: Integers with a relatively small, known range (-200 to 200)
public class UsingTreeMap {
    public static void main(String[] args) {
        UsingTreeMap m = new UsingTreeMap();
        m.recordTemp(-200); //-200,-100,-100,0,0,100,200
        m.recordTemp(-100);
        m.recordTemp(0);
        m.recordTemp(-100);
        m.recordTemp(0);
        m.recordTemp(100);
        m.recordTemp(200);
        System.out.println(m.findMedian());
    }
    Map<Integer, Integer> tempCountMap = new TreeMap<>(); // Indices 0-400 represent temps -200 to 200
    int count = 0;
    public void recordTemp(int temp) {
        tempCountMap.put(temp, tempCountMap.getOrDefault(temp,0)+1);
        count++;
    }

    public double findMedian() {
        if (count % 2 != 0) {
            // Odd: find the (n/2 + 1)th element
            return (double) findNthValue(tempCountMap, count / 2 + 1);
        } else {
            // Even: average of (n/2) and (n/2 + 1)
            int leftMiddle = findNthValue(tempCountMap, count / 2);
            int rightMiddle = findNthValue(tempCountMap, count / 2 + 1);
            return (leftMiddle + rightMiddle) / 2.0;
        }
    }

    /**
     * Helper to find the value at a specific cumulative position
     */
    private static int findNthValue(Map<Integer, Integer> counts, int targetCount) {
        int runningSum = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            runningSum += entry.getValue();
            if (runningSum >= targetCount) {
                return entry.getKey();
            }
        }
        return 0; // Should not reach here with valid n
    }
}
