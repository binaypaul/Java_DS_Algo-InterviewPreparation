package DataStructure.Neetcode.H_Backtracking;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/n-queens/description/
//https://youtu.be/Ph95IHmRp5M?si=ZMCLnceWD5AOGKkP
public class i_NQueens {
    List<List<String>> res = new ArrayList<>();

    Set<Integer> cols = new HashSet<>();
    Set<Integer> positiveDiagonal = new HashSet<>(); //south-west to north-east diagonal
    Set<Integer> negativeDiagonal = new HashSet<>(); //north-west to south-east diagonal

    public List<List<String>> solveNQueens(int n) {
        //create or initialize an n*n board with "."
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        dfs(0, board);
        return res;
    }

    private void dfs(int row, char[][] board) {
        if(row == board.length) {
            addToRes(board);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if(isNotSafe(row, col))
                continue;

            fill(row, col, board);
            dfs(row+1, board);
            undoFill(row, col, board);
        }
    }

    private void fill(int row, int col, char[][] board) {
        cols.add(col);
        positiveDiagonal.add(row+col); //(row,col) pairs which (row+col) and (row-col) are diagonal in matrix.
        negativeDiagonal.add(row-col); //(row,col) pairs which (row+col) and (row-col) are diagonal in matrix.
        board[row][col] = 'Q';
    }

    private void undoFill(int row, int col, char[][] board) {
        cols.remove(col);
        positiveDiagonal.remove(row+col); //(row,col) pairs which (row+col) and (row-col) are diagonal in matrix.
        negativeDiagonal.remove(row-col); //(row,col) pairs which (row+col) and (row-col) are diagonal in matrix.
        board[row][col] = '.';
    }

    private boolean isNotSafe(int row, int col) {
        return cols.contains(col) || positiveDiagonal.contains(row+col) || negativeDiagonal.contains(row-col);
    }

    private void addToRes(char[][] board) {
        //convert String[][] to List<List<String>>
        res.add(new ArrayList<>(Arrays.stream(board).map(x -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < x.length; i++) {
                sb.append(x[i]);
            }
            return sb.toString();
        }).collect(Collectors.toList())));
    }

    public static void main(String[] args) {
        System.out.println(new i_NQueens().solveNQueens(4));
    }
}
