package DataStructure.Neetcode150.D_BinarySearch;

public class e_SearchInRotatedSortedArray_simple {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l<=r) {
            int mid = l+(r-l)/2;
            //base conditions
            if(nums[mid]==target)
                return mid;
            if(nums[l]==target)
                return l;
            if (nums[r]==target)
                return r;
            //[1,2,3,4,5]
            //[3,4,5,1,2]
            //[4,5,1,2,3] 2
            //[5,1,2,3,4]
            if (nums[mid] < nums[r]){
                // mid to r is sorted
                // l to mid is unsorted
                if(target>nums[mid] && target<nums[r]) { // converge search towards sorted part as we know target is in sorted part.
                    l=mid+1;
                } else {
                    r=mid-1;
                }
            } else {
                // mid to r is unsorted
                // l to mid is sorted
                if(target<nums[mid] && target>nums[l]) { // converge search towards sorted part as we know target is in sorted part.
                    r=mid-1;
                } else {
                    l=mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new e_SearchInRotatedSortedArray_simple()
                .search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}