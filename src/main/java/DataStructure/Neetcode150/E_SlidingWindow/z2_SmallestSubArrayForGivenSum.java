package DataStructure.Neetcode150.E_SlidingWindow;


import java.util.Arrays;

public class z2_SmallestSubArrayForGivenSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSmallestSubArray(new int[]{4,2,6,7,5,1,2,4,7}, 8)));
    }                                                                  // 0,1,2,3,4,5,6,7,8

    private static int[] findSmallestSubArray(int[] nums, int target) {
        int left = 0, right = 0, curSum = 0, curSubArrLen = 0;
        int leastSubArrLen = nums.length;
        int leastLeft = 0, leastRight = nums.length-1;


        if(Arrays.stream(nums).sum()<target) {
            return new int[0];
        }

        while (right < nums.length){
            //base con
            if(nums[right] >= target) {
                return Arrays.copyOfRange(nums,right,right+1);
            }


            curSum = curSum + nums[right];
            if (curSum < target) {
                right++;
            } else if (curSum == target) {
                curSubArrLen = right-left + 1;
                if(curSubArrLen < leastSubArrLen) {
                    leastSubArrLen = curSubArrLen;
                    leastLeft = left;
                    leastRight = right;
                }
                leastSubArrLen = Math.min(leastSubArrLen, curSubArrLen);
                curSum = curSum - nums[left];
                left++;
                right++;
            } else {
                curSubArrLen = right-left + 1;
                if(curSubArrLen < leastSubArrLen) {
                    leastSubArrLen = curSubArrLen;
                    leastLeft = left;
                    leastRight = right;
                }
                leastSubArrLen = Math.min(leastSubArrLen, curSubArrLen);
                curSum = curSum - nums[left] - nums[right];
                left++;
            }
        }

        return Arrays.copyOfRange(nums, leastLeft, leastRight+1);
    }
}
