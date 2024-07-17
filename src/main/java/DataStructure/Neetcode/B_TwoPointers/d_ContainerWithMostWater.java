package DataStructure.Neetcode.B_TwoPointers;

public class d_ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,3,2,5,25,24,5}));
    }                                      //0 1 2 3  4  5 6

    public static int maxArea(int[] height) {
        int l =0, r=height.length-1;
        int maxArea = 0;
        while (l<r) {
            int minHeight = Math.min(height[l], height[r]);
            int lengthDiff = r-l;
            int curArea = lengthDiff * minHeight;

            maxArea = Math.max(maxArea, curArea);

            if(height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}