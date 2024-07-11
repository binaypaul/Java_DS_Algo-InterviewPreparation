package DataStructure.NonLinear.Matrix;

public class MatrixUtil {
    public static int [][] create(int m, int n) {
        int [][] grid = new int[m][n];
        for(int rowI = 0; rowI < m; rowI++) {
            for (int columnI = 0; columnI < n; columnI++) {
                grid[rowI][columnI] = 0;
            }
        }
        return grid;
    }

    public static void display(int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;
        System.out.println("{");
        for (int rowI = 0; rowI < rowCount; rowI++) {
            System.out.print("{");
            for (int columnI = 0; columnI < columnCount; columnI++) {

                String cellData = String.valueOf(grid[rowI][columnI]);
                if (columnI < columnCount-1)
                    cellData += ", ";
                System.out.print(cellData);
            }
            System.out.print("}");
            System.out.println();
        }
        System.out.print("}");
        System.out.println();
    }
}
