package DataStructure.Neetcode150.D_BinarySearch;

import java.util.Arrays;

public class z1_FindNumberClosestToTarget_ArraysBinarySearch {
    public static void main(String[] args) {
        System.out.println(new z1_FindNumberClosestToTarget_ArraysBinarySearch()
                .findClosestNum(new int[] {1,13,4,10,7}, 3));
    }

    private int findClosestNum(int[] nums, int target) {
        Arrays.sort(nums); //{1,4,7,10,13}
        int i = Arrays.binarySearch(nums, target);
        if(i>= 0) {
            return target;
        } else if (nums[Math.abs(i+1)]-target < target-nums[Math.abs(i+1)-1]) {
            return nums[Math.abs(i+1)];
        } else {
            return nums[Math.abs(i+1)-1];
        }
    }
}
