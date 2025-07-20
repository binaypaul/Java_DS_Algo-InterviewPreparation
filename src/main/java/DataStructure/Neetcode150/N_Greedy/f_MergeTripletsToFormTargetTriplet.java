package DataStructure.Neetcode150.N_Greedy;

import java.util.Arrays;

public class f_MergeTripletsToFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] canTrip = null;
        for (int[] triplet : triplets) {
            if((triplet[0] == target[0] && triplet[1] <= target[1] && triplet[2] <= target[2])
                    || (triplet[1] == target[1] && triplet[0] <= target[0] && triplet[2] <= target[2])
                    || (triplet[2] == target[2]) && triplet[0] <= target[0] && triplet[1] <= target[1]) {
                if(canTrip == null)
                    canTrip = triplet;
                else {
                    canTrip[0] = Math.max(canTrip[0], triplet[0]);
                    canTrip[1] = Math.max(canTrip[1], triplet[1]);
                    canTrip[2] = Math.max(canTrip[2], triplet[2]);
                }
            }
        }
        return Arrays.equals(canTrip, target);
    }

    public static void main(String[] args) {
//        int[][] triplets = {{2,5,3},{1,8,4},{1,7,5}};
//        int[] target = {2,7,5};
//        int[][] triplets = {{3,4,5},{4,5,6}};
//        int[] target = {3,2,5};
        int[][] triplets = {{2,5,3},{2,3,4},{1,2,5},{5,2,3}};
        int[] target = {5,5,5};
        System.out.println(new f_MergeTripletsToFormTargetTriplet().mergeTriplets(triplets, target));
    }
}