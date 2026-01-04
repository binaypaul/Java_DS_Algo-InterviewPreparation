package DataStructure.Neetcode150.a_a_Practice.Mock3;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MergeIntervals()
                .mergeIntervals(new int[][] {{1,4},{2,3},{5,8},{6,7}})));
    }

    public int[][] mergeIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n<2) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        var merged = new ArrayList<int[]>();
        merged.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int[] last = merged.getLast();
            int[] current = intervals[i];
            //overlapping
            if(last[1] >= current[0]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                merged.add(current);
            }
        }
        return merged.toArray(new int[0][0]);
    }
}