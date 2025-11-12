package DataStructure.Neetcode150.B_TwoPointers.practise;

import java.util.Arrays;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int l = 0, cur = 0, count = 0;
        while (l < nums.length) {
            if(nums[l] == 0) {
                count++;
            } else {
                nums[cur] = nums[l];
                cur++;
            }
            l++;
        }
        while (count > 0) {
            nums[cur] = 0;
            cur++;
            count--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        new MoveZeros().moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
