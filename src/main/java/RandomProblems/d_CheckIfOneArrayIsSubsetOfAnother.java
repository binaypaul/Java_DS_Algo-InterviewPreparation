package RandomProblems;

import java.util.HashMap;

public class d_CheckIfOneArrayIsSubsetOfAnother {

    public static void main(String[] args) {
//        a[] = [11, 1, 13, 21, 3, 7], b[] = [11, 3, 7, 1]
        System.out.println(new d_CheckIfOneArrayIsSubsetOfAnother().check(
                new int[] {11, 1, 13, 21, 3, 7, 1}, new int[] {11, 3, 7, 1,1,1}
        ));
    }

    private boolean check(int[] a, int[] b) {
        var map = new HashMap<Integer, Integer>();
        for (int ai : a) {
            if(!map.containsKey(ai)) {
                map.put(ai, 1);
            } else {
                map.put(ai, map.get(ai) + 1);
            }
        }

        for(int bi : b) {
            if(!map.containsKey(bi) || map.get(bi) <= 0) {
                return false;
            } else {
                map.put(bi, map.get(bi) - 1);
            }
        }
        return true;
    }
}
