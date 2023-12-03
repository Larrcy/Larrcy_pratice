package Char10.S35.LeetCode123;

public class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        // 0: 没有操作,
        // 1: 第一次买入,
        // 2: 第一次卖出,
        // 3: 第二次买入,
        // 4: 第二次卖出

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = prices[0] - prices[0];
        dp[0][3] = -prices[0];
        dp[0][4] = prices[0] - prices[0];

        for (int i = 1; i < prices.length; i++) {
            //前一天不持有股票的最大现金-price就是当前持有股票的钱数
            //第一次持有 前一天已经买入 当天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]-prices[i]);
            //第一次不持有 前一天卖出 当天卖出：前一天的收益+当前天的股票价格
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            //第二次持有 前一天已经买入 ，前一天的收益-当天股票价格
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            //第二次不持有 前一天卖出 前一天的收益+当前股票价格
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        //返回第二次不持有的最大金额即可
        return dp[prices.length - 1][4];
    }
}
