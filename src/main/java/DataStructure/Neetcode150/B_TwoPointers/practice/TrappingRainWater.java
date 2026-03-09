package DataStructure.Neetcode150.B_TwoPointers.practice;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    private int trap(int[] heights) {
        int l = 0, r = heights.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (l < r) {
            if (heights[l] <= heights[r]) {
                leftMax = Math.max(leftMax, heights[l]);  // step 1: update max
                water += leftMax - heights[l];            // step 2: collect water
                l++;
            } else {
                rightMax = Math.max(rightMax, heights[r]);
                water += rightMax - heights[r];
                r--;
            }
        }
        return water;
    }
}