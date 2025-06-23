package DataStructure.Neetcode150.D_BinarySearch;

import java.util.Arrays;

public class c_KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println( minEatingSpeed(
                new int[] {3,6,7,11}, 8
        ) );
    }

    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1, high = piles[piles.length-1];
        int minimum = high;

        while (low <= high) {
            int mid = (low+high)/2;
            double count = eatBanana(piles, mid);
            if(count > h) {
                low = mid + 1;
            } else {
                minimum = Math.min(mid, minimum);
                high = mid -1;
            }
        }
        return minimum;
    }

    public static double eatBanana(int[] piles, int mid) {
        double count = 0.0;
        for (int bananasAtIndex : piles) {
            count = count + Math.ceil(((double) bananasAtIndex/(double) mid));
        }
        return count;
    }

}