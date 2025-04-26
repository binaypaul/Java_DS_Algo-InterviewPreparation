package DataStructure.Topics.Graph.MatrixOrGrid;

import lombok.EqualsAndHashCode;
import lombok.ToString;

//PoJo
@EqualsAndHashCode
@ToString
public class GridRowCol {
    private int row;
    private int col;

    public GridRowCol(int row, int col) {
        this.row = row;
        this.col = col;
    }

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