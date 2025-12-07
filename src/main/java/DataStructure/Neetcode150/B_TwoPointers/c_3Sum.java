package DataStructure.Neetcode150.B_TwoPointers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * https://leetcode.com/problems/3sum/description/
 */
public class c_3Sum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> threeSumList = new ArrayList<>();

            Arrays.sort(nums); //[-4, -1, -1, 0, 1, 2]
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
