package DataStructure.Practice.Sept2026._15;

import java.util.*;
import lombok.*;

public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobArr = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobArr[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobArr, Comparator.comparingInt(j -> j.startTime));
        Integer[][] memo = new Integer[jobArr.length + 1][jobArr.length + 1];
        return dfs(jobArr, -1, 0, memo);
    }

    // Returns: max profit achievable from index i onward, given previ is the last CHOSEN job's index
    private int dfs(Job[] jobArr, int previ, int i, Integer[][] memo) {
        if (i >= jobArr.length) {
            return 0;
        }
        if (memo[previ + 1][i] != null) {
            return memo[previ + 1][i];
        }

        int result;
        if (previ != -1 && jobArr[i].startTime < jobArr[previ].endTime) {
            int skipCur = dfs(jobArr, previ, i + 1, memo);
            int swapPrevForCur = jobArr[i].profit - jobArr[previ].profit + dfs(jobArr, i, i + 1, memo);
            result = Math.max(skipCur, swapPrevForCur);
        } else {
            result = jobArr[i].profit + dfs(jobArr, i, i + 1, memo);
        }

        memo[previ + 1][i] = result;
        return result;
    }

    @AllArgsConstructor
    private static class Job {
        int startTime, endTime, profit;
    }

    public static void main(String[] args) {
        MaximumProfitInJobScheduling maximumProfitInJobScheduling = new MaximumProfitInJobScheduling();
        int[] startTime = {1, 2, 2, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        var ret = maximumProfitInJobScheduling.jobScheduling(startTime,endTime,profit);
        System.out.println(ret);//120
    }
}
