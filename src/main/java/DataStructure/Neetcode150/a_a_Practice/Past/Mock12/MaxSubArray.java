package DataStructure.Neetcode150.a_a_Practice.Past.Mock12;

public class MaxSubArray {
    //[-2,1,-3,4,-1,2,1,-5,4]       6
    //  0,1, 2,3, 4,5,6, 7,8
    public int maxSubArray(int[] nums) {
        int r=0;
        long maxSum = Integer.MIN_VALUE, curSum = Integer.MIN_VALUE;
        int len = nums.length;

        while (r < len) {
            if(nums[r] > curSum + nums[r]) {
                curSum = nums[r];
            } else{
                curSum = curSum + nums[r];
            }
            maxSum = Math.max(curSum, maxSum);
            r++;
        }
        return (int) maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[] {2,-1,3}));
    }
}
