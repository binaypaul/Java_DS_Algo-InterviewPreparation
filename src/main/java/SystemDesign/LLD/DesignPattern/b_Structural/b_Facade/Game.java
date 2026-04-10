package SystemDesign.LLD.DesignPattern.b_Structural.b_Facade;

public class Game {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameState state;

    public Game() {
        this.board = new Board();
        this.playerX = new Player("X");
        this.playerO = new Player("O");
        this.currentPlayer = playerX;
        this.state = GameState.IN_PROGRESS;
    }

    public boolean makeMove(int row, int col) {
        // Coordinates board, player, and state logic
        // Caller doesn't need to understand internal details
        if (state != GameState.IN_PROGRESS) return false;
        if (!board.placeMark(row, col, currentPlayer.getMark())) return false;

        if (board.checkWin(row, col)) {
            state = GameState.WON;
        } else if (board.isFull()) {
            state = GameState.DRAW;
        } else {
            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }
        return true;
    }
}
