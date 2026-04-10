package SystemDesign.LLD.DesignPattern.a_Creational.c_SingletonPattern;

public class Usage {
    public static void main(String[] args) {
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.query("SELECT * FROM users");
    }
}
