package DataStructure.Neetcode150.D_BinarySearch;

public class d_d_FindMaximumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new d_d_FindMaximumInRotatedSortedArray().findMaxWithDup(new int[] {4,5,6,7,8,9,1,2,3}));
    }

    public int findMaxWithDup(int[] nums) {
        int l = 0, r = nums.length - 1;
        //1,2,3,4,5
        //3,4,5,1,2
        //4,5,1,2,3
        while (l<r) {
            int mid = l+(r-l)/2;
            if(nums[mid] < nums[r]) {
                r = mid;
            } else if(nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r--;
            }
        }
        if(l == 0) return nums[nums.length - 1];
        else return nums[l-1];
    }
}