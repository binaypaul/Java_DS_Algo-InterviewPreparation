package DataStructure.Neetcode150.D_BinarySearch;

import java.util.Arrays;
//! to solve via binary search
public class g_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] num1 = new int[] {1,12,15,26,38}; //len 5
        int[] num2 = new int[] {2,13,17,30,45,60}; //len 6
//                              0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10
//                              1, 2,12,13,15,17,26,30,38,45,60
//        int[] num1 = new int[] {2}; //len 5
//        int[] num2 = new int[] {1,3}; //len 6
        System.out.println(new g_MedianOfTwoSortedArrays().findMedianSortedArrays(num1, num2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on smaller array
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int len1 = nums1.length, len2 = nums2.length, totalLen=len1+len2;
        int l = 0, r = len1;
//          nums1={1,12,15,26,38};      //len 5
//          nums2={2,13,17,30,45,60};   //len 6
//                 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10
//                 1, 2,12,13,15,17,26,30,38,45,60
        while (l <= r) {
            // Note:
            // If totalLen (11) is ODD -> count of elem in left part(p1+p2) is 1 greater than right part (totalLen-(p1+p2)) //6 is 1 greater 5
            // If totalLen (eg: 10) is EVEN -> valid partition = count of elem in left part(p1+p2) == right part (totalLen-(p1+p2)) //5==5
            int p1 = (l+(r-l)/2);
            // 0+(5-0)/2=2      // partition in nums1 to span 2 elements at idx 0,1
            int p2 = (totalLen + 1) / 2 - p1;
            // ((11+1)/2)-2=4   // partition in nums2 to span 4 elements at idx 0,1,2,3
            int l1 = p1 == 0 ? Integer.MIN_VALUE : nums1[p1 - 1];
            int r1 = p1 == len1 ? Integer.MAX_VALUE : nums1[p1];
            int l2 = p2 == 0 ? Integer.MIN_VALUE : nums2[p2 - 1];
            int r2 = p2 == len2 ? Integer.MAX_VALUE : nums2[p2];

            if (l1 <= r2 && l2 <= r1) {
                // Valid partition found
                if ((totalLen) % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) {
                r = p1 - 1; // move partition left in nums1
            } else {
                l = p1 + 1; // move partition right in nums1
            }
        }
        return 0.0;
    }
}
