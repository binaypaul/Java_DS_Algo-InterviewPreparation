package DataStructure.RandomFromChatGPT;

import java.util.LinkedList;

/**
 * Problem Statement:
 * Given a binary array nums, return the maximum number of consecutive 1s in the array if you can flip
 * at most 'k' 0.
 *
 * Input: nums = [1,0,1,1,0], k = 1
 * Output: 4    //0 1 2 3 4 5 6 7 8 9
 * Explanation: Flip one of the zeros and get [1,1,1,1,0] or [1,0,1,1,1]
 */
public class d_MaxConsecutiveOnesII {
    public static void main(String[] args) {
        System.out.println(new d_MaxConsecutiveOnesII().findMaxConsecutiveOnes(new int[]{0,0,1,0,1,1,0,1,1,1}, 2));
    }
    public int findMaxConsecutiveOnes(int[] nums, int k){
        int maxCount = 0;
        LinkedList<Integer> zeroIndexes = new LinkedList<>();
        int l = 0, r = 0;
        for (; r < nums.length; r++) {
            if(nums[r] == 0) {
                if(zeroIndexes.size() < k) {
                    zeroIndexes.addLast(r);
                } else {
                    maxCount = Math.max(maxCount, r-l);
                    l = zeroIndexes.removeFirst()+1;
                    zeroIndexes.addLast(r);
                }
            }
        }
        maxCount = Math.max(maxCount, r-l);
        return maxCount;
    }
}
