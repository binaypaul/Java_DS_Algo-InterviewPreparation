package DataStructure.Neetcode150.H_Backtracking.practise;

import java.util.ArrayList;
import java.util.List;
//https://www.youtube.com/watch?v=UP3dOYJa05s
public class a_Subsets_DoubleRecursion {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int i) {
        if(i==nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        backtrack(nums, i+1);

        cur.add(nums[i]);
        backtrack(nums, i+1);
        cur.remove(cur.size()-1);
    }


    public static void main(String[] args) {
        System.out.println(new DataStructure.Neetcode150.H_Backtracking.practise.a_Subsets_DoubleRecursion().subsets(new int[] {1,2,3}));
    }
}
