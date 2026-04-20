package DataStructure.Neetcode150.a_a_Practice.April.Mock_15_04_26;

import java.util.*;

public class TrappingRainWater {
    public int trap(int[] height) {
        int len = height.length;
        int[] lmax = new int[len];
        lmax[0] = height[0];
        for (int i = 1; i < len; i++) {
            if(height[i]>lmax[i-1])
                lmax[i] = height[i];
            else
                lmax[i] = lmax[i-1];
        }

        int[] rmax = new int[len];
        rmax[len-1] = height[len-1];
        for (int i = len-2; i >= 0; i--) {
            if(height[i]>rmax[i+1])
                rmax[i] = height[i];
            else
                rmax[i] = rmax[i+1];
        }

        System.out.println(Arrays.toString(lmax));
        System.out.println(Arrays.toString(rmax));
        int water = 0;
        for (int i = 0; i < len; i++) {
            water+=Math.min(lmax[i],rmax[i])-height[i];
        }
        return water;
    }

    public int trap1(int[] height) {
        int water = 0, l = 0, lmax=Integer.MIN_VALUE, len = height.length, r=len-1, rmax=Integer.MIN_VALUE;

        while (l<r) {
            if(height[l] <= height[r]) {
                lmax = Math.max(lmax, height[l]);
                water+=lmax-height[l];
                l++;
            } else {
                rmax= Math.max(rmax, height[r]);
                water+=rmax-height[r];
                r--;
            }
        }

        return water;
    }

    /*
    Input: height = {0,1,0,2,1,0,1,3,2,1,2,1}
    Output: 6
     */
    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap1(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
