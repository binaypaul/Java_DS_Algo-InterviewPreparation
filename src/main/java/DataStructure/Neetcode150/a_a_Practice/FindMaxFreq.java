package DataStructure.Neetcode150.a_a_Practice;

public class FindMaxFreq {

/*
Find max frequency of elements in an array of length N after K number of increment operations.

Input: arr[] = {1, 4, 8, 13}, N = 4, K = 5
Output: 2

Explanation:
Incrementing arr[0] thrice modifies arr[] to {4, 4, 8, 13}. Maximum frequency = 2.
Incrementing arr[1] four times modifies arr[] to {1, 8, 8, 13}. Maximum frequency = 2.
Incrementing arr[2] five times modifies arr[] to {1, 4, 13, 13}. Maximum frequency = 2.
Therefore, the maximum possible frequency of any array element that can be obtained by at most 5 increments is 2.
Input: arr[] = {2, 4, 5}, N = 3, K = 4
Output: 3

K is the max number of operations, each operation is one increment by 1. K can be applied on any element any number of times
*/
    public static void main(String[] args) {
        int[] arr = {2, 4, 5};
        System.out.println(new FindMaxFreq().findMaxFreqSW(arr, 3,4));
    }
    public int findMaxFreq(int[] arr, int n, int k) {
        int maxFreq = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int ctarget = arr[i];
            int ck = k;
            int cfreq = 1;
            for (int c = i - 1; c >= 0; c--) {
                int cur = arr[c];
                if(ctarget-cur < ck) {
                    cfreq++;
                    ck = ck - (ctarget-cur);
                    maxFreq = Math.max(maxFreq, cfreq);
                } else if (ctarget-cur == ck) {
                    cfreq++;
                    maxFreq = Math.max(maxFreq, cfreq);
                    break;
                } else {
                    maxFreq = Math.max(maxFreq, cfreq);
                    break;
                }
            }
        }
        return maxFreq;
    }

    public int findMaxFreqSW(int[] arr, int n, int k) {
        int left = 0;
        int maxFreq = 0;
        long currentWindowSum = 0;

        for (int right = 0; right < n; right++) {
            currentWindowSum += arr[right];

            // The cost to make all elements in the window [left...right]
            // equal to the current element (arr[right]) is:
            // (Window Width * Target Value) - (Sum of elements currently in window)

            while ((long)arr[right] * (right - left + 1) - currentWindowSum > k) {
                currentWindowSum -= arr[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        return maxFreq;
    }
}