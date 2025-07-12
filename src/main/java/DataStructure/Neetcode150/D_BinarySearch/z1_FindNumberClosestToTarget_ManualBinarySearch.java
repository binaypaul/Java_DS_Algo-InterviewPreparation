package DataStructure.Neetcode150.D_BinarySearch;

import java.util.Arrays;

public class z1_FindNumberClosestToTarget_ManualBinarySearch {
    public static void main(String[] args) {
        System.out.print(new z1_FindNumberClosestToTarget_ManualBinarySearch().findClosestNum(new int[] {1,13,4,10,7}, 3) + " ");

    }

    private int findClosestNum(int[] nums, int target) {
        Arrays.sort(nums);

        int i = binarySearch(nums, target);
        if(i >= 0) {
            return target;
        } else if (nums[Math.abs(i+1)]-target < target-nums[Math.abs(i+1)-1]) {
            return nums[Math.abs(i+1)];
        } else {
            return nums[Math.abs(i+1)-1];
        }
    }

    /**
     * if found,        returns the index of the target <p/>
     * if not found,    returns the position (-insertion index -1) of the insertion point <p/>
     *
     * @param nums int array to search in
     * @param target target to search
     * @return
     * if found,        returns the index of the target <p/>
     * if not found,    returns the position (-insertion index -1) of the insertion point <p/>
     */
    private int binarySearch(int[] nums, int target) {
        if(target < nums[0]) return -1;
        if(target > nums[nums.length-1]) return -(nums.length-1)-2;

        int low=0, high = nums.length-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(target == nums[mid])
                return mid;
            else if (mid > 0 && target > nums[mid-1] && target < nums[mid])
                return -mid-1;
            else if (mid < nums.length-1 && target > nums[mid] && target < nums[mid+1])
                return -mid-2;
            else if(target < nums[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return 0;
    }
}