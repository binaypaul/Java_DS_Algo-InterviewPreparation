package DataStructure.Neetcode150.A_ArraysAndHashing;

import java.util.Arrays;
import java.util.TreeSet;

public class z1_SmallestGreaterElementToTheRight {
    public static void main(String[] args) {
        int[] nums = new int[] {10,9,2,8,3,7,101,18};
        //expected output:     {18,18,3,18,7,18,-1,-1}
        System.out.println(Arrays.toString(smallestGreaterElementToTheRight(nums)));
    }

    private static int[] smallestGreaterElementToTheRight(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        // TreeSet stores elements in sorted order and allows efficient finding of higher elements.
        TreeSet<Integer> set = new TreeSet<>();

        // Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Find the smallest element in the set that is strictly greater than arr[i]
            Integer higher = set.higher(arr[i] + 1);

            if (higher != null) {
                result[i] = higher;
            } else {
                result[i] = -1; // No greater element found to the right
            }
            // Add the current element to the set for future comparisons
            set.add(arr[i]);
        }
        return result;
    }
}
