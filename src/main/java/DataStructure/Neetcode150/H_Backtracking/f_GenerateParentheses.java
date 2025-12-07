package DataStructure.Neetcode150.H_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class f_GenerateParentheses {
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
    //print statements are to show the flow of return of recursive call in debug mode run.
    private static void recurse(int left, int right, String s) {
        System.out.print("");
        if(s.length() == n*2) {
            list.add(s);
            return;
        }
        System.out.print("");
        if(left < n) {
            recurse(left+1, right, s+"(");
        }
        System.out.print("");
        if(right < left) {
            recurse(left, right+1, s+")");
        }
        System.out.print("");
    }
}
