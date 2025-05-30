package DataStructure.Blind75.Array;

import java.util.Arrays;
import java.util.HashMap;

public class a_TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new a_TwoSum().twoSum(new int[]{1, 6, 2, 10, 3}, 7)));
    }
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {Math.min(i, map.get(target - nums[i])), Math.max(i, map.get(target - nums[i]))};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
