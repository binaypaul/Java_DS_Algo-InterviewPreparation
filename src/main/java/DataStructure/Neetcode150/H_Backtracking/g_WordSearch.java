package DataStructure.Neetcode150.H_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/word-search/description/
public class g_WordSearch {
    boolean exist = false;
    List<String> used = new ArrayList<>();
    List<Integer> diagVals = new ArrayList<>();
    public boolean exist(char[][] board, String word) {
        dfs(board, word,0, "", 0,0, board.length-1, board[0].length-1);
        return exist;
    }

    private void dfs(char[][] board, String word, int i, String cword, int startRow, int startCol, int endRow, int endCol) {
        if(cword.equals(word)) {
            exist = true;
            System.out.println(used);
            return;
        }
        outer:
        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                if(used.contains(""+row+col) || //should not consider if already used
                        ((diagVals.size()>=2) ? (row+col == (diagVals.get(diagVals.size()-2)) || row-col == diagVals.get((diagVals.size()-1))) : false) || //should not consider diagonal elements
                        word.charAt(i) != board[row][col])
                    continue;

                used.add("" + row + col);
                diagVals.addAll(Arrays.asList(row+col, row-col)); //(row,col) pairs which (row+col) and (row-col) are diagonal in matrix.
                dfs(board, word,i+1, cword + board[row][col],
                        ((row-1 < 0) ? row : row-1),
                        ((col-1 < 0) ? col : col-1),
                        ((row+1 > board.length-1) ? row : row+1),
                        ((col+1 > board[0].length-1) ? col : col+1));
                if(exist==true)break outer;
                used.remove(used.size()-1);
                diagVals.remove(diagVals.size()-1);
                diagVals.remove(diagVals.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','B'},
                {'A','A','A','A','B','A'}};
        System.out.println(new g_WordSearch().exist(board,"AAAAAAAAAAAAABA")
        );
    }
}
