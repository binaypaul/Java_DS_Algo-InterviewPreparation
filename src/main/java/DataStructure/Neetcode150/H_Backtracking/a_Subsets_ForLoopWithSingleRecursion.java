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
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);                 //add ith elem
            dfs(i+1, nums);             //recursive - move to next elems after ith elem
            cur.remove(cur.size()-1);  //backtrack - remove the last elem from cur
        }

        res.add(new ArrayList<>(cur));  //once i crossed last num, add cur to res
    }

    public static void main(String[] args) {
        System.out.println(new a_Subsets_ForLoopWithSingleRecursion().subsets(new int[] {1,2,3}));
    }
}
