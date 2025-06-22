package DataStructure.Neetcode150.D_BinarySearch;

import java.util.Arrays;
//! to solve via binary search
public class g_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedAr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, mergedAr, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedAr, nums1.length, nums2.length);
        Arrays.sort(mergedAr);
        return mergedAr.length%2==0 ?
                (mergedAr[(mergedAr.length/2)-1] + mergedAr[mergedAr.length/2])/2.0 :
                mergedAr[mergedAr.length/2];
    }
}
