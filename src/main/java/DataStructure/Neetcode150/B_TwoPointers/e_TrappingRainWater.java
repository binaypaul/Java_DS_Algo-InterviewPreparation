package DataStructure.Neetcode150.B_TwoPointers;

//https://leetcode.com/problems/trapping-rain-water/description/

public class e_TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(new e_TrappingRainWater().trap_prefixMaxSuffixMaxApproach(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    //! prefix max & suffix max approach
    public int trap_prefixMaxSuffixMaxApproach(int[] height) {
        int len = height.length;
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];

        prefixMax[0] = height[0];
        for (int l = 1; l < len; l++) {
            if(height[l] > prefixMax[l-1])
                prefixMax[l] = height[l];
            else
                prefixMax[l] = prefixMax[l-1];
        }

        suffixMax[len-1] = height[len-1];
        for (int r = len-2; r >= 0; r--) {
            if(height[r] > suffixMax[r+1])
                suffixMax[r] = height[r];
            else
                suffixMax[r] = suffixMax[r+1];
        }


        int total = 0;

        for (int i = 0; i < len; i++) {
            if(prefixMax[i] > height[i] && suffixMax[i] > height[i]) {
                total+= Math.min(prefixMax[i], suffixMax[i]) - height[i];
            }
        }

        return total;
    }

    //! space optimised  prefix max & suffix max approach
    public int trap_OptimisedPrefixMaxSuffixMaxApproach(int[] height) {
        int len = height.length;
        int[] suffixMax = new int[height.length];

        suffixMax[len-1] = height[len-1];
        for (int r = len-2; r >= 0; r--) {
            if(height[r] > suffixMax[r+1])
                suffixMax[r] = height[r];
            else
                suffixMax[r] = suffixMax[r+1];
        }


        int total = 0;
        int prevPrefixMax = 0;
        for (int i = 0; i < len; i++) {
            if(prevPrefixMax > height[i] && suffixMax[i] > height[i]) {
                total += Math.min(prevPrefixMax, suffixMax[i]) - height[i];
            }
            prevPrefixMax = Math.max(prevPrefixMax, height[i]);
        }
        return total;
    }

    //! 2 pointer approach
    public int trapWater_2pointerApproach(int[] heights) {
        if (heights == null || heights.length < 3) return 0;
        int left = 0, right = heights.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;

        while (left < right) {
            if (heights[left] <= heights[right]) {
                if (heights[left] >= leftMax) {
                    leftMax = heights[left];
                } else {
                    water += leftMax - heights[left];
                }
                left++;
            } else {
                if (heights[right] >= rightMax) {
                    rightMax = heights[right];
                } else {
                    water += rightMax - heights[right];
                }
                right--;
            }
        }
        return water;
    }
}
