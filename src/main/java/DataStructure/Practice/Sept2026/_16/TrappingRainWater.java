package DataStructure.Practice.Sept2026._16;

public class TrappingRainWater {
    public int trap(int[] height) {
        var len = height.length;
        if(len==0) return 0;
        int water = 0;
        int l=0, r=len-1,leftMax=height[0], rightMax=height[len-1];

        while (l<r) {
            if(rightMax>=leftMax) {
                if(leftMax>height[l]) {
                    water+=leftMax-height[l];
                }
                leftMax = Math.max(leftMax, height[l]);
                l++;
            } else {
                if(rightMax>height[r]) {
                    water+=rightMax-height[r];
                }
                rightMax = Math.max(rightMax, height[r]);
                r--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {4,2,0,3,2,5};
        var ret = trappingRainWater.trap(height);
        System.out.println(ret);
    }
}