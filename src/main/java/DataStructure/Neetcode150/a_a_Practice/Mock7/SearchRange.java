package DataStructure.Neetcode150.a_a_Practice.Mock7;

import java.util.*;

public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchRange().searchRange1(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
    public int[] searchRange(int[] nums, int target) {
        var pos = Arrays.binarySearch(nums, target);
        if(pos < 0) return new int[]{-1,-1};

        var startingPos = pos;
        while (startingPos-1 >=0 & nums[startingPos-1] == target) {
            startingPos--;
        }

        var endingPos = pos;
        while (endingPos+1 <= nums.length-1 && nums[endingPos+1] == target) {
            endingPos++;
        }
        return  new int[]{startingPos, endingPos};
    }
    public int[] searchRange1(int[] nums, int target) {
        int startingPos = Integer.MAX_VALUE;
        int l=0, r= nums.length-1;
        while (l<=r) {
            int mid = l+(r-l)/2;
            if(nums[mid] == target) {
                startingPos = Math.min(startingPos, mid);
                r=mid-1;
            } else if(nums[mid] > target) {
                r=mid-1;
            } else {
                l=mid+1;
            }
        }
        if(startingPos==Integer.MAX_VALUE) return new int[]{-1,-1};

        int endingPos = Integer.MIN_VALUE;
        l=0; r= nums.length-1;
        while (l<=r) {
            int mid = l+(r-l)/2;
            if(nums[mid] == target) {
                endingPos = Math.max(endingPos, mid);
                l=mid+1;
            } else if(nums[mid] > target) {
                r=mid-1;
            } else {
                l=mid+1;
            }
        }
        return new int[]{startingPos, endingPos};
    }
}
