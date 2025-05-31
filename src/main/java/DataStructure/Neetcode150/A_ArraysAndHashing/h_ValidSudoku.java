package DataStructure.Neetcode150.A_ArraysAndHashing;

public class h_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

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
