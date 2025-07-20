package DataStructure.Neetcode150.N_Greedy;
//https://leetcode.com/problems/hand-of-straights/description/

import java.util.Arrays;

/**
 * Alice has some number of cards, and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
 *
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
 */
public class e_HandOfStraights {
    public static void main(String[] args) {
        System.out.println(new e_HandOfStraights().isNStraightHand(
                new int[] {1,1,2,2,3,3},
                2
        ));
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(groupSize == 1) return true;
        if(hand.length % groupSize != 0) return false;

        Arrays.sort(hand);
        int noOfGroups = hand.length/groupSize;
        int curGrp = 0;
        int nextGrp = curGrp+1;

        //tracks the size of each group
        int[] grpSizes = new int[noOfGroups];
        grpSizes[0] = 1;

        //tracks the last element in each group
        Integer[] lastElemInGroup = new Integer[noOfGroups];
        lastElemInGroup[0] = hand[0];

        for (int i = 1; i < hand.length; i++) {
            //if current i value is same as prev i val
            if(hand[i] == hand[i-1]) {
                if(nextGrp >= noOfGroups) return false;
                else if(lastElemInGroup[nextGrp] == null || hand[i]-lastElemInGroup[nextGrp] == 1)
                    lastElemInGroup[nextGrp] = hand[i];
                else return false;

                //setup for next iteration
                grpSizes[nextGrp] = grpSizes[nextGrp] + 1;
                nextGrp++;
                if(grpSizes[curGrp] >= groupSize) curGrp++;
            } else {
                if(curGrp >= noOfGroups) return false;
                else if(lastElemInGroup[curGrp] == null || hand[i]-lastElemInGroup[curGrp] == 1)
                    lastElemInGroup[curGrp] = hand[i];
                else return false;

                //setup for next iteration
                grpSizes[curGrp] = grpSizes[curGrp] + 1;
                nextGrp = curGrp+1;
                if(grpSizes[curGrp] >= groupSize) curGrp++;
            }
        }
        return true;
    }
}
