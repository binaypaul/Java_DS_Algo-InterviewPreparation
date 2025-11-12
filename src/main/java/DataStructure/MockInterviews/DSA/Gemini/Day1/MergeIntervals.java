package DataStructure.MockInterviews.DSA.Gemini.Day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Question 1: Merge Intervals
 * Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since [1,3] and [2,6] overlap, merge them into [1,6].
 */

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MergeIntervals().mergeIntervals(
                new int[][]{{1,4},{4,5}}
        )));
    }

    public int[][] mergeIntervals(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        var mergedIntervals = new ArrayList<int[]>();
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i-1][1] >= intervals[i][0]) { //overlapping
                if(intervals[i-1][1] > intervals[i][1]) {
                    intervals[i] = intervals[i-1];
                } else {
                    intervals[i] = new int[]{intervals[i-1][0], intervals[i][1]};
                }
            } else {
                mergedIntervals.add(intervals[i-1]);
            }
        }
        mergedIntervals.add(intervals[intervals.length-1]);
        return mergedIntervals.toArray(new int[0][0]);
    }
}
