import java.util.*;
import java.util.stream.*;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().houseRobberII(new int[]{1,2,3}));
    }
    public int houseRobberII(int[] nums) {
        //nums=[2,9,8,3,6]
        int[] memo = new int[nums.length];
        int[] memo1 = new int[nums.length];
        Arrays.fill(memo, -1);
        Arrays.fill(memo1, -1);
        return Math.max(
                dp(Arrays.copyOfRange(nums, 0, nums.length-1), memo1, nums.length-1),
                dp(Arrays.copyOfRange(nums, 1, nums.length), memo, nums.length-1)
        );
    }

    int dp(int[] nums, int[] memo, int i) {
        if(i < 1) return 0;
        if(memo[i] != -1) return memo[i];

        memo[i] = Math.max(
                nums[i-1] + dp(nums, memo, i-2),
                dp(nums, memo, i-1)
        );
        return memo[i];
    }
}