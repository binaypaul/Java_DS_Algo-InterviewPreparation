package DataStructure.Practice.Sept2026._16;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> retSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            var target = -nums[i];
            int l = i+1, r = nums.length-1;
            while (l<r) {
                if(nums[l] + nums[r] > target) {
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    retSet.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
            }
        }
        return new ArrayList<>(retSet);
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {0,1,1};
        var ret = threeSum.threeSum(nums);
        System.out.println(ret);
    }
}
