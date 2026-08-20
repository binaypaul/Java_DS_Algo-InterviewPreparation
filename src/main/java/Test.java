import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Test().twoSum(new int[]{2,3,8,4,11,6,5}, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();

        for(int i=0;i< nums.length;i++) {
            if(map.containsKey(target-nums[i])) {
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}