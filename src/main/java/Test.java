public class Test {
    public static void main(String[] args) {
        for (int i = 65; i <= 90; i++) {
            char c = (char)i;
            System.out.print(c+"_"+i + ", ");
        }

        System.out.println(Integer.parseInt(""+'1'+'1')+64);
    }
}