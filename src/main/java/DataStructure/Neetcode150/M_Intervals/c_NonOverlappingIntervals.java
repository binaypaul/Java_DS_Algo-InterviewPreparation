package DataStructure.Neetcode150.M_Intervals;

import java.util.Arrays;

public class c_NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x,y) -> Integer.compare(x[0], y[0]));
        int count = 0;
        int prevIndex = -1;
        for (var i = 0; i < intervals.length; i++) {
            if(intervals[i] == null) {
                continue;
            }

            if(prevIndex == -1) {
                prevIndex = i;
                continue;
            }

            //find if prev and cur is overlapping or not
            if(intervals[prevIndex][1]<=intervals[i][0]) {
                //not overlapping
                prevIndex = i;
            } else {
                //overlapping
                if (intervals[prevIndex][1] > intervals[i][1]) {
                    intervals[prevIndex] = null;
                    prevIndex = i;
                } else
                    intervals[i] = null;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new c_NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}}));
    }
}
