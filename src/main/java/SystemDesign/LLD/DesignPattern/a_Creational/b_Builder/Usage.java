package SystemDesign.LLD.DesignPattern.a_Creational.b_Builder;

public class Usage {
    public static void main(String[] args) {
        HttpRequest request = new HttpRequest.Builder()
                .url("https://api.example.com")
                .method("POST")
                .header("Content-Type", "application/json")
                .body("{\"key\": \"value\"}")
                .build();
    }
}
