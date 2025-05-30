package DataStructure.Neetcode150.C_Stack;

import java.util.ArrayList;
import java.util.List;

public class d_GenerateParentheses {
    static List<String> list = new ArrayList<>();
    static int n = 0;

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int num) {
        int left = 0, right = 0;
        String s = "";
        n = num;

        recurse(left, right, s);
        return list;
    }

    private static void recurse(int left, int right, String s) {
        if(s.length() == n*2) {
            list.add(s);
            return;
        }
        if(left < n) {
            recurse(left+1, right, s+"(");
        }

        if(right < left) {
            recurse(left, right+1, s+")");
        }
    }
}
