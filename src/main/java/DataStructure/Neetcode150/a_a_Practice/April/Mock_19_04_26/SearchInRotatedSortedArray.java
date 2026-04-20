package DataStructure.Neetcode150.a_a_Practice.April.Mock_19_04_26;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray()
                .search(new int[]{4,5,6,7,0,1,2}, 3));
    }
    public int search(int[] nums, int target) {
        int l=0,r= nums.length-1;
        while (l<=r) {
            int mid = l+(r-l)/2;
            if(target==nums[mid])
                return mid;
            if(nums[mid]>=nums[l]) {
                if(target >= nums[l] && target < nums[mid]) {
                    r=mid-1;
                } else {
                    l=mid+1;
                }
            } else if(nums[mid]<=nums[r]) {
                if(target <= nums[r] && target > nums[mid]) {
                    l=mid+1;
                } else {
                    r=mid-1;
                }
            }
        }
        return -1;
    }
    /*
                  [0,1,2,4,5,6,7]
    Input: nums = [4,5,6,7,0,1,2], target = 0
                  [5,6,7,0,1,2,4]
                  [6,7,0,1,2,4,5]
                   0,1,2,3,4,5,6
    Output: 4
     */
}
