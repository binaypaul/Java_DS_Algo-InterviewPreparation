package DataStructure.Practice.Sept2026._15;

import java.util.*;

public class MaximumProfitInJobScheduling_BinarySearch {
    public static void main(String[] args) {
        MaximumProfitInJobScheduling_BinarySearch maximumProfitInJobScheduling = new MaximumProfitInJobScheduling_BinarySearch();
        int[] startTime = {1, 2, 2, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        var ret = maximumProfitInJobScheduling.jobScheduling(startTime,endTime,profit);
        System.out.println(ret);//120
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.endTime));

        // dp[i] = max profit considering the first i jobs (in end-time order)
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            Job cur = jobs[i - 1];
            int skip = dp[i - 1];
            int takeIndex = findLastNonOverlapping(jobs, i - 1, cur.startTime);
            int take = cur.profit + dp[takeIndex + 1];
            dp[i] = Math.max(skip, take);
        }

        return dp[n];
    }

    // Binary search for the rightmost job (index < upTo) whose endTime <= targetStart
    private int findLastNonOverlapping(Job[] jobs, int upTo, int targetStart) {
        int lo = 0, hi = upTo - 1, result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (jobs[mid].endTime <= targetStart) {
                result = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }

    private static class Job {
        int startTime, endTime, profit;
        Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}
