package DataStructure.Neetcode150.C_MonotonicDeque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Example 1:
 *
 * Input: nums = [3,1,-1,-3,5,3,6,7], k = 3
 * Output: [3,1,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [3  1  -1] -3  5  3  6  7       3
 *  3 [1  -1  -3] 5  3  6  7       1
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 */

//! monotonic deque problem

public class f_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // Stores indices (not values)
        for (int i = 0; i < nums.length; i++) {
            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() == i-k){
                deque.pollFirst();
            }
            // Remove indices from the last if current element is larger than the last elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
            if(i>=k-1)
                result[i-k+1] = nums[deque.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new f_SlidingWindowMaximum()
                        .maxSlidingWindow(new int[]{1, -1, 3, -3, 5, 3, 6, 7}, 3)
                )
        );
    }
}
