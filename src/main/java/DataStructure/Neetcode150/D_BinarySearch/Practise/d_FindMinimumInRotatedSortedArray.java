package DataStructure.Neetcode150.D_BinarySearch.Practise;

public class d_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new d_FindMinimumInRotatedSortedArray()
                .findMin(new int[] {4,5,6,7,1,2,3}));
                                 // 0 1 2 3 4 5 6
    }

    int min = Integer.MAX_VALUE;
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left<=right) {
            int mid = left + (right-left)/2;
            min = Math.min(nums[mid], min);

            if(nums[left]<= nums[mid]) {//right side till mid is sorted
                min = Math.min(nums[left], min);
                left = mid+1;
            } else {//left side from mid is sorted
                right = mid-1;
            }
        }
        return min;
    }
}
