package DataStructure.Blind75.Array;

public class b_BestTimeToBuyAndSellStock {
    public int stockBuySell(int[] arr) {
        if (arr.length < 2) return 0;

        var maxProfit = 0;
        int b = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < b) {
                b = arr[i];
            } else {
                maxProfit = Math.max(maxProfit, arr[i] - b);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new b_BestTimeToBuyAndSellStock().stockBuySell(new int[]{1, 1, 1, 1, 30, 50, 20, 1}));
    }
}