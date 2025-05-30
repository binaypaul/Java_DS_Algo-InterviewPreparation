package DataStructure.Neetcode150.A_ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class a_ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : nums) {
            Integer num = map.get(j);
            if (num == null) {
                map.put(j, j);
            } else {
                return true;
            }
        }
        return false;
    }
}