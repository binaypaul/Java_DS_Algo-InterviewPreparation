package DataStructure.Neetcode.D_BinarySearch;

public class a_BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12,13}, 9));
    //                                       0 1 2 3 4  5  6
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid+1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
