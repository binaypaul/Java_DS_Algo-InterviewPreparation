package DataStructure.Neetcode150.A_ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class c_TwoSums {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,3,3}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                return new int []{i, map.get(rem)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}