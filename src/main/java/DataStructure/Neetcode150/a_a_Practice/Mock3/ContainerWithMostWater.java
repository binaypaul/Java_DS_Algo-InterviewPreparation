package DataStructure.Neetcode150.a_a_Practice.Mock3;

import java.util.*;

public class ContainerWithMostWater {


    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater()
                .findMaxWaterContainer(new int[] {1,8,6,2,9,5,4,8,3,7}));
                                                //0,1,2,3,4,5,6,7
    }

    public int findMaxWaterContainer(int[] heights) {
        int l = 0, r = heights.length-1;
        int max = Integer.MIN_VALUE;
        while (l<r) {
            if(heights[l] < heights[r]) {
                max = Math.max(max, heights[l]*(r-l));
                l++;
            } else {
                max = Math.max(max, heights[r]*(r-l));
                r--;
            }
        }
        return max;
    }
}
