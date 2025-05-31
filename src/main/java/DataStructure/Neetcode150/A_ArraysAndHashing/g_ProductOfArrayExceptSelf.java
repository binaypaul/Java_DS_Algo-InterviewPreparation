package DataStructure.Neetcode150.A_ArraysAndHashing;

import java.util.Arrays;

public class g_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new g_ProductOfArrayExceptSelf().productExceptSelf(new int[]{1,2,3,4})));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if(i==j) continue;
                prod*=nums[j];
            }
            res[i] = prod;
        }
        return res;
    }
}
