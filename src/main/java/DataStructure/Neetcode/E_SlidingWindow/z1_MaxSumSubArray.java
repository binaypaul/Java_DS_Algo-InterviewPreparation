package DataStructure.Neetcode.E_SlidingWindow;

public class z1_MaxSumSubArray {
    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray(new int []{4,2,1,7,8,1,2,8,1,0}, 3));
    }                                                  //0,1,2,3,4,5,6,7,8,9

    public static int findMaxSumSubArray(int[] arr, int k) {
        int curMax =0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            curMax = curMax + arr[i];
            if(i >= k-1) {
                max = Math.max(curMax, max);
                curMax = curMax - arr[i-k+1];
            }
        }
        return max;
    }
}
