import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        char[] ips = new char[] {'a','b','c','d','e'};
        System.out.println(Stream.of(ips)
                .map(ip -> String.valueOf(ip))
                .reduce(String::concat).get());
        char c = 'a';
        String s = String.valueOf(c);
        System.out.println(s);
    }
}
