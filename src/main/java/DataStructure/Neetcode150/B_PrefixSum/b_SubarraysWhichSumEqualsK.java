package DataStructure.Neetcode150.B_PrefixSum;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 * Input: nums = [1, 1, 1, 2], k = 3
 * Output: {[1,1,1], [1,2]}
 * Explanation: [1,1,1] at positions (0,2) and [1,2] at positions (2,3)
 */
public class b_SubarraysWhichSumEqualsK {
    public static void main(String[] args) {
        var res = new b_SubarraysWhichSumEqualsK().subarraySum(new int[] {1, 1, 1, 2, 5, -2, -5, 3}, 3);
        for(int[] subarr : res)
            System.out.println(Arrays.toString(subarr));
    }
    public Set<int[]> subarraySum(int[] nums, int k) {
        var res = new LinkedHashSet<int[]>();
        var sum = 0;
        //! key: sum of nums values till i from 0,  value: Set of (1+i), "1" is a constant,"i" is the index in array till values in nums arr adds to be equal to sum.
        //* Note:
        //*      There could be multiple index where sum of values till that index creates same sum.
        //*      Constant "1" is added to i in the value set of map, so that we can create subarr (line 34) from the next index till which sum was previously put in map.
        //?      (Bit tricky to understand, remove +1 in line 40 to see what actually happens)
        var sumTillIdxPlusOneSetMap = new HashMap<Integer, Set<Integer>>(){{put(0, new HashSet<>(){{add(0);}});}};
        //I/P: nums: {1, 1, 1, 2, 5, -2, -5, 3}, k=3;
        for (var i = 0; i < nums.length; i++) {
            sum+=nums[i];

            Set<Integer> tillIdxSet = sumTillIdxPlusOneSetMap.get(sum-k);
            if(tillIdxSet != null) {
                for(int tillIdx : tillIdxSet) {
                    int[] subarr = Arrays.copyOfRange(nums, tillIdx, i+1); //{1, 1, 1, 2, 5, -2, -5, 3}
                    res.add(subarr);
                }
            }

            Set<Integer> tempSet = sumTillIdxPlusOneSetMap.getOrDefault(sum, new HashSet<>());
            tempSet.add(i+1);
            sumTillIdxPlusOneSetMap.put(sum, tempSet);
        }
        return res;
    }
}