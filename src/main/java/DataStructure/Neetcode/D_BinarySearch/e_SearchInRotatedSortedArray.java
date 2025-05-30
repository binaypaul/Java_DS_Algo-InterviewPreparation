package DataStructure.Neetcode.D_BinarySearch;

public class e_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l =0, r= nums.length-1;
        while (l<=r) {
            int mid =(l+r)/2;
            if(target == nums[mid]) return mid;

            //left sorted portion of rotated array
            if(nums[mid] >= nums[l]) {
                if(target > nums[mid] || target < nums[l]) {
                    l = mid+1;
                } else {    //(target > nums[l] && target < nums[mid]) {
                    r = mid - 1;
                }
            }
            //right sorted portion of rotated array
            else {
                if(target < nums[mid] || target > nums[r]) {
                    r = mid -1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new e_SearchInRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
