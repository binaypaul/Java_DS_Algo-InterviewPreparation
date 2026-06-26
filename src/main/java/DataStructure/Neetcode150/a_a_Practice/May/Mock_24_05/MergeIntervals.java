package DataStructure.Neetcode150.a_a_Practice.May.Mock_24_05;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(
                new int[][]{{1,4}, {4,5}}
        )));
    }

    public int[][] merge(int[][] intervals) {
        /*
        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
         */

        Arrays.sort(intervals, (x,y) -> x[0]-y[0]);
        var ret = new ArrayList<int[]>();
        ret.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] fromArr = intervals[i];
            //overlapping
            if(fromArr[0] <= ret.getLast()[1]) {
                int[] fromList = ret.removeLast();
                fromList[0]=Math.min(fromArr[0],fromList[0]);
                fromList[1]=Math.max(fromArr[1],fromList[1]);
                ret.add(fromList);
            } else {
                //not overlapping
                ret.add(fromArr);
            }
        }
        return ret.toArray(new int[0][]);
    }
}
