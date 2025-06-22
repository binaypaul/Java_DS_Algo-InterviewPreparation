package DataStructure.Neetcode150.C_Stack;

import java.util.Stack;

//https://leetcode.com/problems/online-stock-span/description/
public class z2_OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner ss = new StockSpanner();
        System.out.println(ss.next(100));
        System.out.println(ss.next(80));
        System.out.println(ss.next(60));
        System.out.println(ss.next(70));
        System.out.println(ss.next(60));
        System.out.println(ss.next(75));
        System.out.println(ss.next(85));
    }
}

class StockSpanner {
    Stack<PriceSpan> stack = null;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        if (stack.isEmpty() || stack.peek().price > price) {
            stack.push(new PriceSpan(price, 1));
            return 1;
        } else {
            int span = 0;
            while (!stack.isEmpty() && stack.peek().price <= price) {
                PriceSpan priceSpan = stack.pop();
                span += priceSpan.span;
            }
            stack.push(new PriceSpan(price, 1 + span));
            return 1+span;
        }
    }
}

class PriceSpan {
    int price, span;

    public PriceSpan(int price, int span) {
        this.price = price;
        this.span = span;
    }

    @Override
    public String toString() {
        return "PriceSpan{" +
                "price=" + price +
                ", span=" + span +
                '}';
    }
}