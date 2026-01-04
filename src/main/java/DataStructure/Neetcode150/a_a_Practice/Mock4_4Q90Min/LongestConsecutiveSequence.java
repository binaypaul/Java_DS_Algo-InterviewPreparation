package DataStructure.Neetcode150.a_a_Practice.Mock4_4Q90Min;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().lcs(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
//{1,2,3,4,6,7,8}
    private int lcs(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            if(set.contains(num+1))
                continue;

            var len = 1;
            while (set.contains(num-1)) {
                len++;
                num-=1;
            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}
