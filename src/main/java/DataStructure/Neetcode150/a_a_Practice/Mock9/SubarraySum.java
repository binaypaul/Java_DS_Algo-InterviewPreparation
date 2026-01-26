package DataStructure.Neetcode150.a_a_Practice.Mock9;

import java.util.*;

public class SubarraySum {
    public static void main(String[] args) {
        int[] nums5 = {1,1,1,-1,1,1};
        int k5 = 2;
        System.out.println(new SubarraySum().subarraySum(nums5, k5));
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0,1);
        int count = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(sumCountMap.containsKey(sum-k)) {
                count+=sumCountMap.get(sum-k);
            }
            sumCountMap.put(sum, sumCountMap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}