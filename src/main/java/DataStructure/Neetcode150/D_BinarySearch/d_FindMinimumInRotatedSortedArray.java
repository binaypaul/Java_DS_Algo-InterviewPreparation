package DataStructure.Neetcode150.D_BinarySearch;

public class d_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] {3,4,5,1,2}));
    }

//    should be solved via binary search technique
    public static int findMin(int[] nums) {
        int min= Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}
