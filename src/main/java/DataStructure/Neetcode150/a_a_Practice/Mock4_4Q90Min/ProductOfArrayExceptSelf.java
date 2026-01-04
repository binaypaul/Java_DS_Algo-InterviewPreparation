package DataStructure.Neetcode150.a_a_Practice.Mock4_4Q90Min;

import java.util.*;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf()
                .prod(new int[]{1,2,3,4})));
                               //0,1,2, 3,4
    }

    private int[] prod(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        int[] p = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) {
            p[i] = left;
            left *=nums[i];
        }
        int[] s = new int[n];
        int right = 1;
        for (int i = n-1; i >= 0; i--) {
            s[i] = right;
            right *=nums[i];
        }
        for (int i = 0; i < n; i++) {
            ret[i] = p[i] * s[i];
        }
        return ret;
    }
}
