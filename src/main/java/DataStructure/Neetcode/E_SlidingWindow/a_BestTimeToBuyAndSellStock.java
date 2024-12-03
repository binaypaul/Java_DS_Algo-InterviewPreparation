package DataStructure.Neetcode.E_SlidingWindow;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class a_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2}));
    }

    public static int maxProfit(int[] prices) {
        /*
        if(prices.length <= 1) return 0;

        int buyPr = prices[0], sellPr = 0, curPr, curPro, maxPro = 0;

        for(int i = 1; i < prices.length; i++) {
            curPr = prices[i];
            if(curPr > buyPr) {
                sellPr = curPr;

                curPro = sellPr - buyPr;
                if(curPro > maxPro)
                    maxPro = curPro;
            } else {
                buyPr = curPr;
            }
        }
        return maxPro;
        */

        int buy = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            } else if((prices[i] - buy) > profit) {
                profit = (prices[i] - buy);
            }
        }
        return profit;
    }
}
