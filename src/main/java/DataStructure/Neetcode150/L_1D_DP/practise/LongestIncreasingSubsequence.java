package DataStructure.Neetcode150.L_1D_DP.practise;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(
                new int[] { 10, 9, 2, 5, 3, 4, 18, 20 }));
                        //   0  1  2  3  4  5   6   7
    }
    int maxLen = 1;
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int lenAtI = dp(nums, i, Integer.MIN_VALUE, memo);
            maxLen = Math.max(maxLen, lenAtI);
        }
        return maxLen;
    }

    private int dp(
            int[] nums,
            int start,
            int prev,
            int[] memo)
    {
        if(start >= nums.length)  return 0;
        if(memo[start] != 0) return memo[start];

        int length = 0;
        for (int i = start; i < nums.length; i++) {
            if(nums[i] > prev) {
                int curLen = dp(nums, i+1, nums[i], memo);
                length = Math.max(curLen+1, length);
            }
        }
        return memo[start] = Math.max(length, memo[start]);
    }
}