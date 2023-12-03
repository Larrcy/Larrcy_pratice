package Char10.S37.LeetCode309;

public class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        //设dp有4个状态
        //dp[i][0] 持股
        //dp[i][1] 保持卖出股票(股票已卖出)
        //dp[i][2] 卖出股票
        //dp[i][3] 冷冻期

        //持有股票 当天可买入
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;

        for (int i = 1; i < prices.length; i++) {
            //dp[i-1][0] 前一天持有股票
            //dp[i-1][3]-prices[i]前一天是冷冻期 当天买入
            //dp[i-1][1]-prices[i] 前一天是保持卖出股票的状态 第i天买入
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            //dp[i - 1][1] 前一天保持卖出股票的状态
            //dp[i - 1][3] 前一天为冷冻期
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2]=dp[i-1][0]+prices[i];
            dp[i][3]=dp[i-1][2];
        }
        //1 2 3都有可能取最大值
        return Math.max(dp[prices.length-1][3],Math.max(dp[prices.length-1][1], dp[prices.length-1][2]));
    }
}
