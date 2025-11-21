package DataStructure.Concepts.Graph.MatrixOrGrid;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//PoJo
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class GridRowCol {
    private int row;
    private int col;

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    public int val(int[][] grid) {
        return grid[this.row()][this.col()];
    }

    public char val(char[][] grid) {
        return grid[this.row()][this.col()];
    }

    public String val(String[][] grid) {
        return grid[this.row()][this.col()];
    }
}