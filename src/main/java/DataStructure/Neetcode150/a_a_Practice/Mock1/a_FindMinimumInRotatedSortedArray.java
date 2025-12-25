package DataStructure.Neetcode150.a_a_Practice.Mock1;

public class a_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new a_FindMinimumInRotatedSortedArray().findMin(new int[]{1,3,3}));
    }
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        int l = 0, r = nums.length-1;
        while (l<=r) {
            int mid = l+(r-l)/2;//8
            min = Math.min(min, nums[mid]);

            if(nums[l] <= nums[mid]) {
                l=mid+1;
            } else {
                if(nums[r] >= nums[mid]) {
                    r=mid-1;
                } else {
                    l = mid+1;
                }
            }
        }
        return min;
    }
}
