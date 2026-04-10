package SystemDesign.LLD.DesignPattern.b_Structural.b_Facade;

public class Usage {
    public static void main(String[] args) {
        Game game = new Game();
        game.makeMove(0, 0);
        game.makeMove(1, 1);
    }
}
