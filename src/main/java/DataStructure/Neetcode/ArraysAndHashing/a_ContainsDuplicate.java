package DataStructure.Neetcode.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class a_ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num = map.get(nums[i]);
            if (num == null) {
                map.put(nums[i], nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}
