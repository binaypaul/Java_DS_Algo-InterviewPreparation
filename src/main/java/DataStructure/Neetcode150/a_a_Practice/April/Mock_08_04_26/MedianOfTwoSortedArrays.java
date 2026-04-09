package DataStructure.Neetcode150.a_a_Practice.April.Mock_08_04_26;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(
                new int[]{1,3,5,7,9},
                new int[]{2,4,6,8,10,11}
                       // 1,2,3,4,5,6,7,8,9,10,11 -> merged; op: 6
                       // 0,1,2,3,4,5,6,7,8,9,10 ->idx
        ));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
            return findMedianSortedArrays(nums2,nums1);

        int len1=nums1.length, len2=nums2.length, totalLen=len1+len2;
        int l=0, r=len1;
        while (l<=r) {
            int p1 = l+(r-l)/2; //2
            int p2 = (totalLen+1)/2-p1; //4

            int l1 = p1==0?Integer.MIN_VALUE:nums1[p1-1]; //1,3
            int r1 = p1==len1?Integer.MAX_VALUE:nums1[p1]; //2,4,6,8
            int l2 = p2==0?Integer.MIN_VALUE:nums2[p2-1];//5,7,9
            int r2 = p2==len2?Integer.MAX_VALUE:nums2[p2];//10,11

            if(l1<=r2 && l2<=r1) {
                //valid partition
                if(totalLen%2==1) {
                    return Math.max(l1,l2);
                } else {
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
            } else if (l2>r1) {
                l=p1+1;
            } else {
                r=p1-1;
            }
        }
        return 0.0;
    }
}
