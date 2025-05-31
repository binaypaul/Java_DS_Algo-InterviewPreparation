package DataStructure.Neetcode150.A_ArraysAndHashing;

import java.util.HashSet;

public class i_LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(new i_LongestConsecutiveSequence().longestConsecutive(
                new int[] {0,3,7,2,5,8,4,6,0,14}
        ));
    }


    public int longestConsecutive(int[] nums) {
        var numset = new HashSet<Integer>();
        for(int num : nums) {
            numset.add(num);
        }

        int longestCon = 0;
        for(int num : numset) {
            if(!numset.contains(num-1)) {
                int curNum = num;
                int curCon = 1;
                while (numset.contains(curNum+1)) {
                    curNum++;
                    curCon++;
                }
                longestCon = Math.max(longestCon, curCon);
            }
        }
        return longestCon;
    }
}
