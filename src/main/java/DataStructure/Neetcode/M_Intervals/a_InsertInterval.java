package DataStructure.Neetcode.M_Intervals;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/insert-interval/description/
/*
Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
 */
public class a_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var len = intervals.length;
        if(len == 0){
            return new int[][]{newInterval};
        }
        var resIntervals = new ArrayList<int[]>();

        for (var i = 0; i < len; i++) {
            if(newInterval[1] < intervals[i][0]) {
                resIntervals.add(newInterval);
                resIntervals.addAll(Arrays.asList(Arrays.copyOfRange(intervals, i, len)));
                return resIntervals.toArray(new int[resIntervals.size()][]);
            } else if(newInterval[0] > intervals[i][1]) {
                resIntervals.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        resIntervals.add(newInterval);

        return resIntervals.toArray(new int[resIntervals.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
                        new a_InsertInterval().insert(new int[][]{{5,7}, {9,11}, {13,15}}, new int[]{8,10})
                )
        );
    }
}