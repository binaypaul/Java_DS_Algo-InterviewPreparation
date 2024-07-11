package DataStructure.Neetcode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c_3Sum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,0,0,0}));
    }

        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> threeSumList = new ArrayList<>();

            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));

            for (int i = 0; i < nums.length-2; i++) {
                // Skip duplicate values for the first element
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int l = i+1, r = nums.length - 1;
                int target = - nums[i];
                while (l<r) {
                    if (nums[l] + nums[r] > target) {
                        r--;
                    } else if (nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                        threeSumList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        // Skip duplicate values for the left element
                        while (l<r && nums[l] == nums[l+1]) {
                            l++;
                        }
                        // Skip duplicate values for the right element
                        while (l<r && nums[r] == nums[r-1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }
            return threeSumList;
    }
}
