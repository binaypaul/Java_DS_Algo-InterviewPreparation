package DataStructure.Concepts.Graph.MatrixOrGrid;

public class Matrix {
    private int [][] matrix = null;

    public Matrix( int [][] matrix) {
        this.matrix = matrix;
    }

    public static void main(String[] args) {
        //'0' represents valid path
        //'1' represents blocked path
        new Matrix(new int[][]{
                {0,0,0,0},
                {1,1,0,0},
                {0,0,0,1},
                {0,1,0,0}
        }); //shortest path is: (1,0)->(0,1)->(0,2)->(1,2)->(2,2)->(3,2)->(3,3)
    }
}