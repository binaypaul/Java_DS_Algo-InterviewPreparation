package DataStructure.Neetcode150.a_a_Practice.April.Mock_08_04_26;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(
                new int[]{2,1}, 7
        ));
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var cur = new ArrayList<Integer>();
        backTrack(candidates, target, 0, cur);
        return res;
    }

    private void backTrack(int[] can, int target, int i, ArrayList<Integer> cur) {
        if(i == can.length || target<=0) {
            if(target==0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        cur.add(can[i]);
        backTrack(can, target-can[i], i, cur);
        cur.removeLast();

        backTrack(can, target, i+1, cur);
    }
    /*
    Input: candidates = {2,3,6,7}, target = 7
    Output: [[2,2,3],[7]]
     */
}