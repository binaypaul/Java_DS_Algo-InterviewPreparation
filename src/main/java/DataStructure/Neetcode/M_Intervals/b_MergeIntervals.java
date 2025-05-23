package DataStructure.Neetcode.M_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class b_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        var mergedIntervals = new ArrayList<int[]>();
        var i = 0;
        while (i < intervals.length-1){
            if(intervals[i][1] >= intervals[i+1][0] && intervals[i][1] <= intervals[i+1][1]) {
                intervals[i+1][0] = intervals[i][0];
            } else if (intervals[i][1] >= intervals[i+1][0] && intervals[i][1] >= intervals[i+1][1]) {
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = intervals[i][1];
            } else {
                mergedIntervals.add(intervals[i]);
            }
            i++;
        }
        mergedIntervals.add(intervals[i]);
        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
//                        new b_MergeIntervals().merge(new int[][]{{1,4},{2,3}})
                        new b_MergeIntervals().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})
                )
        );
    }
}
