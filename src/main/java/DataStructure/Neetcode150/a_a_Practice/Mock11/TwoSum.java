package DataStructure.Neetcode150.a_a_Practice.Mock11;

public class TwoSum {
                        //[2,4,5,6,11,15], 9
    private int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            if(nums[l]+nums[r] > target) {
                r--;
            } else if(nums[l]+nums[r] < target) {
                l++;
            } else return new int[]{l+1, r+1};
        }
        return new int[]{-1,-1};
    }
}
