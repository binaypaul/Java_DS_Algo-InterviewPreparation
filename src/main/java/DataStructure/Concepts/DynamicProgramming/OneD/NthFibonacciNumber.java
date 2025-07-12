package DataStructure.Concepts.DynamicProgramming.OneD;

import java.util.HashMap;

public class NthFibonacciNumber {
    public static void main(String[] args) {
        System.out.println(new NthFibonacciNumber().nthFiboBF(6));
        System.out.println(new NthFibonacciNumber().nthFiboMemo(6, new HashMap<Integer, Integer>()));
        System.out.println(new NthFibonacciNumber().nthFiboTabu(6));
    }
//!    Since we're using top-down recursion, we'll start computing from n-1 down to 0.
    //! bruteforce / simple recursion
    public int nthFiboBF(int n) {
        if(n < 2)
            return n;
        int n1 = nthFiboBF(n-1);
        int n2 = nthFiboBF(n-2);
        return n1 + n2;
    }
//!    Since we're using top-down recursion, we'll start computing from n-1 down to 0.
    //! DP: memoization or top-down
    public int nthFiboMemo(int n, HashMap<Integer, Integer> cache) {
        if(n<2)
            return n;

        if(cache.containsKey(n))
            return cache.get(n);

        cache.put(n, nthFiboMemo(n-1, cache) + nthFiboMemo(n-2, cache));

        return cache.get(n);
    }

    //! DP: tabulation or bottom-up
    public int nthFiboTabu(int n) {
        if (n < 2)
            return n;

        int[] table = new int[]{0,1};

        for (int i = 2; i <= n; i++) {
            int sum = table[0] + table[1];
            table[0] = table[1];
            table[1] = sum;
        }
        return table[1];
    }
    // 0 1 1 2 3 5 8
    // 0 1 2 3 4 5 6

}
