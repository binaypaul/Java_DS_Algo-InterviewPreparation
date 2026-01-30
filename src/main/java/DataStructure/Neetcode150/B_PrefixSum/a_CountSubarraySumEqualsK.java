package DataStructure.Neetcode150.B_PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 * Input: nums = [1, 1, 1, 2], k = 3
 * Output: 2
 * Explanation: [1,1,1] at positions (0,2) and [1,2] at positions (2,3)
 */
public class a_CountSubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(new a_CountSubarraySumEqualsK().subarraySum(new int[] {1, 1, 1, 2, 5, -2, -5, 3}, 3));
    }                                                                           //1  2  3  5  10  8   3  0
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0,1);

        int count  = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];

            if(sumCount.containsKey(sum-k)) {
                count=count+sumCount.get(sum-k);
            }

            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        System.out.println(sumCount);
        return count;
    }
}
