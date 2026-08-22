package DataStructure.Neetcode150.A_ArraysAndHashing;

import java.util.*;

public class e_Top_K_Frequent_Elements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[] { 2, 2, 2, 2, 1, 1, 1, 3, 3, 3, 3, 3 }, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));

        // List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        // entries.sort(Comparator.<Map.Entry<Integer,
        // Integer>>comparingInt(Map.Entry::getValue).reversed());
        //
        // int[] retArr = new int[k];
        // for (int i = 0; i < k; i++) {
        // retArr[i] = entries.get(i).getKey();
        // }
        // return retArr;

        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .mapToInt(Map.Entry::getKey).limit(k).toArray();
    }
}