package DataStructure.Neetcode150.D_BinarySearch;

public class d_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new d_FindMinimumInRotatedSortedArray().findMinWithDup(new int[] {4,5,6,7,8,9,1,2,3}));
    }

    public int findMinWithDup(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--; // Handle duplicates
            }
        }
        return nums[left];
    }
}