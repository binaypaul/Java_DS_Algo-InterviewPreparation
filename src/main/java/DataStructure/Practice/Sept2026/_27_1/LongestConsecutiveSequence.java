package DataStructure.Practice.Sept2026._27_1;

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1;
        for (Integer num : set) {
            if(!set.contains(num-1)) {
                int len = 0;
                while (set.contains(num)) {
                    len++;
                    num++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
//        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        var ret = longestConsecutiveSequence.longestConsecutive(nums);
        System.out.println(ret);
    }
}
