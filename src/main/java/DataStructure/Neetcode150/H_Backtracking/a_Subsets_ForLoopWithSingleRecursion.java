package DataStructure.Neetcode150.H_Backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/description/
//https://www.youtube.com/watch?v=3tpjp5h3M6Y
public class a_Subsets_ForLoopWithSingleRecursion {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int start, int[] nums) {
        res.add(new ArrayList<>(cur));  // Add current subset BEFORE branching
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);       // Add ith elem
            dfs(i + 1, nums); // Recurse to next elements after ith
            cur.removeLast();       // Backtrack - remove the last elem from cur
        }
    }

    public static void main(String[] args) {
        System.out.println(new a_Subsets_ForLoopWithSingleRecursion().subsets(new int[] {1,2,3}));
        //O/P: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    }
}