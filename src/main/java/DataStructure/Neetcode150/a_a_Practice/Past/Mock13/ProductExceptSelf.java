package DataStructure.Neetcode150.a_a_Practice.Past.Mock13;

import java.util.*;

public class ProductExceptSelf {
    //[1,2,3,4]
    //[24,12,8,6]
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] lprod = new int[n];
        lprod[0] = 1;

        for (int i = 1; i < n; i++) {
            lprod[i] = lprod[i-1]*nums[i-1];
        }
        //[1,1,2,6]

        int prevr = 1;
        for (int i = n-2; i >=0 ; i--) {
            lprod[i] = prevr*nums[i+1]*lprod[i];
            prevr = prevr*nums[i+1];
        }
        return lprod;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
