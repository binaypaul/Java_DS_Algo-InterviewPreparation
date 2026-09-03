package DataStructure.Practice.September2026._03.M1;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4}; //[2, 3] -> 6
        System.out.println(new MaximumProductSubarray().maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int max = nums[0], minProd = nums[0], maxProd = nums[0];
        // Your implementation here
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if(cur<0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            minProd = Math.min(cur, cur*minProd);
            maxProd = Math.max(cur, cur*maxProd);

            max = Math.max(max, maxProd);
        }
        return max;
    }
}