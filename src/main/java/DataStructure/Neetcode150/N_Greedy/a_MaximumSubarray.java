package DataStructure.Neetcode150.N_Greedy;

public class a_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int curMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSoFar = Math.max(curMax, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new a_MaximumSubarray()
                .maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})
        );
    }
}
