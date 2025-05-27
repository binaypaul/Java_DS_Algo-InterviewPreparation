package DataStructure.Concepts.Graph;

import DataStructure.Concepts.Graph.MatrixOrGrid.Matrix;

public class AdjacencyMatrix {
    private int [][] matrix = null;

    public AdjacencyMatrix( int [][] matrix) {
        this.matrix = matrix;
    }

    public static void main(String[] args) {
        new Matrix(new int[][]{
              // 0 1 2 3
                {0,0,0,0}, //0
                {1,1,0,0}, //1
                {0,0,0,1}, //2
                {0,1,0,0}  //3
        }); //need to be a square matrix.
            // 4*4 matrix means total 4 nodes
            //rows index means source node and column index is target node
            //'1' value means edge between source to column
            // '0' value means no edge
            // above AdjacencyMatrix creates below graph:
            //         ----
            //        |   |
            // 0 <--- 1---
            //        ^
            //        |
            // 2 ---> 3
    }
}