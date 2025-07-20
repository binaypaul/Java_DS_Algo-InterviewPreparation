package DataStructure.Neetcode150.N_Greedy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class g_PartitionLabels {
    public static void main(String[] args) {
        System.out.println(new g_PartitionLabels().partitionLabels("a"));
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        var map = new LinkedHashMap<Character, int[]>();

        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            if(map.containsKey(si)) {
                map.get(si)[1] = i;
            } else {
                map.put(si, new int[]{i,i});
            }
        }
        int[] window = map.pollFirstEntry().getValue();
        while (!map.isEmpty()) {
            int[] curElemWindow = map.pollFirstEntry().getValue();

            if(curElemWindow[0] > window[0] && (curElemWindow[0] < window[1])) {
                window[1] = Math.max(window[1], curElemWindow[1]);
            } else {
                res.add(window[1]-window[0]+1);
                window = curElemWindow;
            }
        }
        res.add(window[1]-window[0]+1);
        return res;
    }
}
