import java.util.*;
import java.util.stream.*;

public class Test1 {

    public static void main(String[] args) {
        List<String> passwords = List.of("$$$$$$$$$");
        String str = passwords.stream()
                .filter(password->password.matches("^(?=.*[a-zA-Z])(?=.*\\d).{5,}$"))
                .collect(Collectors.joining(" "));
        System.out.println(str);
    }

}