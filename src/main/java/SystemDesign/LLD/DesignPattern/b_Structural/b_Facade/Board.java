package SystemDesign.LLD.DesignPattern.b_Structural.b_Facade;

public class Board {
    public boolean placeMark(int row, int col, String mark) {
        // Place mark logic
        return true;
    }

    public boolean checkWin(int row, int col) {
        // Check win logic
        return false;
    }

    public boolean isFull() {
        // Check if board is full
        return false;
    }
}
