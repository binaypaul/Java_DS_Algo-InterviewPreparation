package DataStructure.Neetcode150.D_BinarySearch;

public class e_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while (low<=high) {
            int mid = low+(high-low)/2;
            if(nums[mid] == target) return mid;

            //in case of the array contains duplicates
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            //Determine which side of mid is sorted:
            if(nums[low] <= nums[mid]) {//left side is sorted - starting from low till mid is sorted
                //Check where the target lies wrt low, mid, high.
                if(nums[low] <= target && target < nums[mid]) { //Target is in between low and mid-1
                    high = mid-1;
                } else { //Target is in between mid+1 and high
                    low = mid+1;
                }
            } else {//right side is sorted - starting from mid till high is sorted
                //Check where the target lies wrt low, mid, high.
                if(target <= nums[high] && target > nums[mid]) { //Target is in between mid+1 and high
                    low = mid+1;
                } else { //Target is in between low and mid-1
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new e_SearchInRotatedSortedArray()
                .search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}