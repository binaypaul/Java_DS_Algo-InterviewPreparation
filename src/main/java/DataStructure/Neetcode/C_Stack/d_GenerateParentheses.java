package DataStructure.Neetcode.C_Stack;

import java.util.ArrayList;
import java.util.List;

public class d_GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int left = 0, right = 0;
        String s = "";
        recurse(left, right, list, s, n);
        return list;
    }

    private static void recurse(int left, int right, List<String> list, String s, int n) {
        if(s.length() == n*2) {
            list.add(s);
            return;
        }
        if(left < n) {
            recurse(left+1, right, list, s+"(", n);
        }

        if(right < left) {
            recurse(left, right+1, list,s+")", n);
        }
    }
}
