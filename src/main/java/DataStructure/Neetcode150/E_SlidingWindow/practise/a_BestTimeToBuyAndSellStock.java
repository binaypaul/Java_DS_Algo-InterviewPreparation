package DataStructure.Neetcode150.E_SlidingWindow.practise;

public class a_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1,8}));
    }

    private static int maxProfit(int[] prices) {
        int i = 0, j = 1, profit = 0;
        while (i < j && j < prices.length) {
            if(prices[j] < prices[i]) {
                i = j;
            } else {
                profit = Math.max(profit, (prices[j] - prices[i]));
            }
            j++;
        }
        return profit;
    }
}