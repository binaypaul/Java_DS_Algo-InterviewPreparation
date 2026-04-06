package DataStructure.Neetcode150.a_a_Practice.March.Mock_28_03_26;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MergeIntervals()
                .merge(new int[][]{{1,4},{4,5}})));
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((x)-> x[0]));
        var res = new ArrayList<int[]>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            var cur = intervals[i];
            var prev = res.getLast();
            //overlapping
            if(cur[0] <= prev[1]) {
                if(prev[1] < cur[1]) {
                    res.removeLast();
                    res.add(new int[]{prev[0], cur[1]});
                }
            }
            //non-overlapping
            else {
                res.add(cur);
            }
        }
        return res.toArray(new int[0][]);
    }
}
