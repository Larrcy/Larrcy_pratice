package Char10.S39.LeetCode714;

public class Solution {
    public static void main(String[] args) {
        int[] prices={1,3,7,5,10,3};
        int fee =3;
        System.out.println(maxProfit(prices, fee));
    }
    public static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        //0表示持有股票 1表示不持有股票
        dp[0][0] = -prices[0]-fee;

        for (int i = 1; i < prices.length; i++) {
            //前一天不持有股票的最大现金-price就是当前持有股票的钱数
            dp[i][0]= Math.max(dp[i-1][0],-prices[i]+dp[i-1][1]-fee);
            dp[i][1]=Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        int max = Math.max(dp[prices.length - 1][1], dp[prices.length - 1][0]);
        return max>=0?max:0;
    }
    }

