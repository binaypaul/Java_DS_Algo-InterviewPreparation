package DataStructure.Neetcode150.L_1D_DP;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/decode-ways/
public class g_DecodeWays {
    private Map<String, Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        int x = dpR(s);
        return x;
    }

    private int dpR(String s) {
        if(s.isEmpty()) return 1;
        if(s.charAt(0) == '0') return 0;
        if(memo.containsKey(s)) return memo.get(s);

        int count = 0;

        count += dpR(s.substring(1));

        if (s.length() >= 2) {
            int twoDigit = Integer.parseInt(s.substring(0, 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                count += dpR(s.substring(2));
            }
        }

        memo.put(s,count);

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new g_DecodeWays().numDecodings("123"));
    }
}
/**
 * For example, "123" can be decoded into:
 *      ABC (1,2,3)
 *      LC (12, 3)
 *      AW (1, 23)
 */


/*
For example, "11106" can be decoded into:
        "AAATF" with the grouping (1, 1, 1, 20, 6)
        "AKTF" with the grouping (1, 11, 20, 6)
        "KATF" with the grouping (11, 1, 20, 6)
*/
