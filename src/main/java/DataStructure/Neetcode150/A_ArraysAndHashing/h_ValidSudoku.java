package DataStructure.Neetcode150.A_ArraysAndHashing;

public class h_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        return validateRows(board) && validateCols(board) && validateBoxes(board);
    }

    private boolean validateRows(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] arr = new int[board.length];
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.') {
                    if (arr[((int) board[i][j]) - 49] != 0)
                        return false;
                    arr[((int) board[i][j]) - 49] = 1;
                }
            }
        }
        return true;
    }

    private boolean validateCols(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] arr = new int[board.length];
            for (int j = 0; j < board[i].length; j++) {
                if(board[j][i] != '.') {
                    if (arr[((int) board[j][i]) - 49] != 0)
                        return false;
                    arr[((int) board[j][i]) - 49] = 1;
                }
            }
        }
        return true;
    }

    private boolean validateBoxes(char[][] board) {
        for (int b = 0; b < board.length; b++) {
            int[] arr = new int[9];
            for (int i = ((b/3)*3); i < ((b/3)*3)+3; i++) {
                int j = 0;
                if(b%3==0) j = 0;
                else if(b%3==1) j = 3;
                else j = 6;

                for (int k=j; k < j+3; k++) {
                    if(board[i][k] != '.') {
                        if (arr[((int) board[i][k]) - 49] != 0)
                            return false;
                        arr[((int) board[i][k]) - 49] = 1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]
            {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
            };
        System.out.println(new h_ValidSudoku().isValidSudoku(board));
    }
}
