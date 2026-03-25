package DataStructure.Neetcode150.a_a_Practice.Mock13;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{4,2,0,3,2,5}));
    }
    public int trap(int[] height) {
        int n = height.length;
        int l=0,r=n-1,lmax=height[0],rmax=height[n-1], water = 0;

        while (l<r) {
            if(height[l] <= height[r]) {
                lmax = Math.max(lmax, height[l]);
                water+=lmax-height[l];
                l++;
            } else {
                rmax = Math.max(rmax, height[r]);
                water+=rmax-height[r];
                r--;
            }
        }
        return water;
    }
}
