package DataStructure.Topics.Matrix;

/**
 * Examples :
 *
 * Input :  m = 2, n = 2;
 * Output : 2
 * There are two paths
 * (0, 0) -> (0, 1) -> (1, 1)
 * (0, 0) -> (1, 0) -> (1, 1)
 *
 * Input :  m = 2, n = 3;
 * Output : 3
 * There are three paths
 * (0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
 * (0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
 * (0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
 **/
public class Count_All_Possible_Paths_From_Top_Left_To_Bottom_Right_Of_A_mXn_Matrix {
    static int countOfPath = 0;
    static String path = "";

    public static void countNumberOfPath(int m, int n) {
        int[][] grid = MatrixUtil.create(m, n);
        MatrixUtil.display(grid);
        dfs(grid, 0, 0);
    }

    private static void dfs(int[][] grid, int rowIndex, int columnIndex) {
        path = "(" + rowIndex + ", " + columnIndex + ")";    //To print path
        int rowCount = grid.length;
        int columnCount = grid[0].length;
        if(rowIndex == rowCount-1 && columnIndex == columnCount-1) {
            countOfPath++;
            System.out.println(path);   //To print path
//            path="";
            return;
        } else {
            System.out.print(path + "->");     //To print path
        }
        //Go down
        if(rowIndex < rowCount - 1) {
            dfs(grid, rowIndex + 1, columnIndex);
        }
        //Go right
        if(columnIndex < columnCount - 1) {
            dfs(grid, rowIndex, columnIndex + 1);
        }
    }

    public static void main(String[] args) {
        countNumberOfPath(2,3);
        System.out.println(countOfPath);
    }
}
