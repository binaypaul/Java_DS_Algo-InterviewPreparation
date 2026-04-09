package DataStructure.Neetcode150.D_BinarySearch;

public class d_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new d_FindMinimumInRotatedSortedArray()
                .findMinWithDup(new int[] {4,5,6,7,8,9,1,2,3}));
                                        // 0,1,2,3,4,5,6,7,8
    }
/*
** when to use "while (l<r)" vs "while (l<=r)" in binary search! Here's the rule of thumb:

*while (l <= r) — use when:

You're searching for a specific value and want to check every element including when l == r
You return inside the loop when found
Example: classic binary search for a target value

while (l <= r) {
    int mid = l + (r - l) / 2;
    if (nums[mid] == target) return mid;
    else if (nums[mid] < target) l = mid + 1;
    else r = mid - 1;
}
return -1; // not found

*while (l < r) — use when:

You're searching for a boundary or minimum/maximum and want to converge l and r to the same point
You return after the loop — the answer is at nums[l] or nums[r]
Example: find minimum in rotated array, first bad version

while (l < r) {
    int mid = l + (r - l) / 2;
    if (condition) r = mid;
    else l = mid + 1;
}
return nums[l]; // l == r, answer converged

*Key insight:

l <= r → you're finding something
l < r → you're converging to something

*
** Comparison Summary
Here is the breakdown of why nums[right] is the reliable anchor:

*1. The "Sorted" Ambiguity.
In a rotated sorted array, if nums[mid] > nums[left], you cannot definitively say which side the minimum is on.
Case A (No Rotation/Search Right): [1, 2, 3, 4, 5]. Here mid (3) > left (1). The minimum is to the left.
Case B (Rotated/Search Right): [3, 4, 5, 1, 2]. Here mid (5) > left (3). The minimum is to the right.

?Because nums[mid] > nums[left] can happen in both a fully sorted and a rotated array, you don't know which way to move your pointers.

*2. The Unambiguous right Comparison.
Comparing with the right boundary provides a clear signal regardless of whether the array is currently "rotated" within your search window:
?If nums[mid] > nums[right]: You are guaranteed that the "pivot" (the drop-off point) exists between mid and right. The array is currently rotated.
?If nums[mid] < nums[right]: The segment from mid to right is perfectly sorted. Therefore, the minimum must be at mid or somewhere to its left.

*Comparison Summary
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
        //5,1,2,3,4
        while (l<r) {
            int mid = l+(r-l)/2;
            if (nums[mid] < nums[r]) { //check Comparison Summary to understand why mid element is compared with right element.
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid+1;
            } else {
                r--; // Handle duplicates.
            }
        }
        return nums[l]; //nums[r] also will work
    }
}

/*
    * for finding min, compare mid "less than" left or right, and choose the unambiguous condition.
    * for finding max, compare mid "greater than" left or right, and choose the unambiguous condition.
 */