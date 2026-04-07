package DataStructure.Neetcode150.a_a_Practice.April.Mock_06_04_26;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArray()
                .findMin(new int[]{11,13,15,17}));
    }
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int min = Integer.MAX_VALUE;
        int l = 0, r=nums.length-1;
        while (l<r) {
            int mid = l+((r-l)/2);
            if(nums[mid] < nums[r]) {
                r=mid;
            } else {
                l=mid+1;
            }
            min=Math.min(min,nums[mid]);
        }
        return min;
    }
    /*
        1,2,3,4,5
        3,4,5,1,2
        5,1,2,3,4
     */
}
