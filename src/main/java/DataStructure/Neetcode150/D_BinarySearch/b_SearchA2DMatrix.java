package DataStructure.Neetcode150.D_BinarySearch;

public class b_SearchA2DMatrix {
    public static void main(String[] args) {    //    0 1 2 3    4  5  6  7     8  9  10 11
        System.out.println(searchMatrix(new int[][]{ {1,3,5,7}, {10,11,16,20}, {23,30,34,60} }, 60));
    }                                              //             1,1             2,1


    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;       // 3
        int n = matrix[0].length;    // 4
        int low = 0, high = n*m - 1;      // 11

        while (low <= high) {
            int mid = (low + high)/2;   // 5
            int row = mid/n;   //1
            int col = mid%n;   //1

            if(target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
