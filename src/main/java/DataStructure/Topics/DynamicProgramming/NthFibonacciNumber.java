package DataStructure.Topics.DynamicProgramming;

import java.util.Arrays;

public class NthFibonacciNumber {

    /////////////////////////////////////////////////////////////////////////////////////////////////
    /* simple recursive program for nth Fibonacci number */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////////////////////////////////////////////
    /* dynamic programming solution with memoization technique for nth Fibonacci number */
    static int[] table = null;
    static int nil = -1;

    public static void initialize(int n) {
        table = new int[n];
        Arrays.fill(table, nil);
    }

    public static int dp_memoization_fib(int n) {
        if (table[n] == nil) {
            if (n <= 1) {
                table[n] = n;
            } else {
                table[n] = dp_memoization_fib(n - 1) + dp_memoization_fib(n - 2);
            }
        }
        return table[n];
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////////////////////////////////////////////
    /* dynamic programming solution with tabulation technique for nth Fibonacci number */
    public static int dp_tabulation_fib(int n) {
        int table[] = new int[n+1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++)
            table[i] = table[i-1] + table[i-2];
        return table[n];
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////

    //Driver code
    public static void main(String[] args) {
        int n = 45;
        //===With dp_memoization
        initialize(n + 1);
        int ans = dp_memoization_fib(n);
//        for (int i: table) {
//            System.out.print(i + ",");
//        }
        System.out.println();
        System.out.println("dp_memoization_fib: " + ans);
        //===
        //===With dp_tabulation
        System.out.println("dp_tabulation_fib: " + dp_tabulation_fib(n));
        //===
        //===With simple recursive.
        System.out.println("fib: " + fib(n));
        //====
    }
}
