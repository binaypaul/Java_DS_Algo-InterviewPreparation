package DataStructure.Neetcode150.A_ArraysAndHashing;

import java.util.Arrays;

public class g_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new g_ProductOfArrayExceptSelf().productExceptSelf(new int[]{2,3,4,5})));
    }
    // I/p:                  [2,3,4,5]
    // prefixProd:           [1,2,6,24]
    // prefixProd:           [60,20,5,1]
    // O/p:                  [60,40,30,24]
    public int[] productExceptSelf(int[] nums) {
        //! brute force
        /*
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prod=1;
            for (int j = 0; j < nums.length; j++) {
                if(i!=j)
                    prod = prod*nums[j];
            }
            res[i] = prod;
        }
        return res;
        */

        //! prefix prod
        /*
        int n = nums.length;
        int[] res = new int[n];
        int[] prefixProd = new int[n];
        int[] suffixProd = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) {
            prefixProd[i] = left;
            left = left*nums[i];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            suffixProd[i] = right;
            right = right*nums[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = prefixProd[i] * suffixProd[i];
        }
        return res;
        */

        var totalProd = 1;
        var zeroIndex = -1;
        var zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] ==0) {
                zeroCount++;
                zeroIndex = i;
            } else {
                totalProd *= nums[i];
            }
        }
        if(zeroCount>1) {
            Arrays.fill(nums, 0);
        } else if(zeroCount == 1){
            Arrays.fill(nums, 0);
            nums[zeroIndex] = totalProd;
        } else {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                nums[i] = totalProd/num;
            }
        }
        return nums;
    }
}
