package DataStructure.Neetcode150.D_BinarySearch;

import java.util.Arrays;

public class c_KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[] {3,6,7,11}, 8));
//        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368},1000000000));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l=1,r=piles[piles.length-1];
        int min=r;

        while (l<=r) {
            int mid = l+(r-l)/2;
            long requiredHours = eatBanana(piles, mid);
            if(requiredHours <= h) {
                min = Math.min(min, mid);
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return min;
    }
    //koko is eating 'mid' numbers of banana every hour.
    private static long eatBanana(int[] piles, int mid) {
        // long is used because if each pile is Integer.MAX_VALUE and h=Integer.MAX_VALUE and mid=1; then required hours is sum of each pile which crosses Integer.MAX_VALUE adn so long is required. (eg: test case 2)
        long requiredHours=0;
        for (int pile : piles) {
            if(pile<=mid) {
                // koko will just need 1 hour to eat all banana in that pile.
                requiredHours+=1;
            } else {
                // koko will need 'pile/mid' hour to eat most bananas, plus 1 hour to eat remaining banana in that pile.
                // eg: koko eating at 3 bananas every hour and a pile has 8 bananas;
                // so koko will need 'pile/mid'=2 hour,
                // plus 1 more hour to eat the remailing 2 bananas if there are remaining bananas.
                requiredHours+=(pile%mid==0)?(pile/mid):pile/mid+1;
            }
        }
        return requiredHours;
    }
}