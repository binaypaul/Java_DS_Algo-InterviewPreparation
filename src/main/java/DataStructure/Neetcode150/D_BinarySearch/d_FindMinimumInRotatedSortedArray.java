package DataStructure.Neetcode150.D_BinarySearch;

public class d_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new d_FindMinimumInRotatedSortedArray().findMinWithDup(new int[] {4,5,6,7,8,9,1,2,3}));
    }
/*
* Comparison Summary
Here is the breakdown of why nums[right] is the reliable anchor:

1. The "Sorted" Ambiguity.
In a rotated sorted array, if nums[mid] > nums[left], you cannot definitively say which side the minimum is on.
Case A (No Rotation/Search Right): [1, 2, 3, 4, 5]. Here mid (3) > left (1). The minimum is to the left.
Case B (Rotated/Search Right): [3, 4, 5, 1, 2]. Here mid (5) > left (3). The minimum is to the right.

?Because nums[mid] > nums[left] can happen in both a fully sorted and a rotated array, you don't know which way to move your pointers.

2. The Unambiguous right Comparison.
Comparing with the right boundary provides a clear signal regardless of whether the array is currently "rotated" within your search window:
?If nums[mid] > nums[right]: You are guaranteed that the "pivot" (the drop-off point) exists between mid and right. The array is currently rotated.
?If nums[mid] < nums[right]: The segment from mid to right is perfectly sorted. Therefore, the minimum must be at mid or somewhere to its left.

Comparison Summary
Comparison	    Result	            Meaning
mid > right	    Discard Left	    The "drop" hasn't happened yet; min is to the right.
mid < right	    Discard Right	    The right side is increasing normally; min is to the left (including mid).
mid > left	    Ambiguous	        Could be a normal sorted array OR a rotated one.
The "Duplicates" Exception.

It's worth noting that if the array contains duplicates (e.g., [3, 3, 1, 3]), even comparing with right becomes tricky. In that specific case, if nums[mid] == nums[right], you can't be sure where the minimum is, so you have to prune the search space by simply doing right--.
*/
    public int findMinWithDup(int[] nums) {
        int l = 0, r = nums.length - 1;
        //1,2,3,4,5
        //3,4,5,1,2
        //4,5,1,2,3
        //?If the array is rotated more than 0 times.
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {  //check Comparison Summary to understand why mid element is compared with right element.
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--; // Handle duplicates.
            }
        }
        return nums[l];
        //?
    }
}