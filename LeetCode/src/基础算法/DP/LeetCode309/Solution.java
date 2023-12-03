package 基础算法.DP.LeetCode309;

//无限次交易 但有冷冻期 即卖出后第二天无法买入
public class Solution {
    //考虑四个状态
    //1.持有股票
    //2.之前已经卖出股票 当天不操作即不在冷冻期(为了迎合冷冻期的买入操作)
    //3.当天卖出股票
    //4.冷冻期
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //dp[i-1][0] 前一天持有股票
            //dp[i-1][3]-prices[i]前一天是冷冻期 当天买入
            //dp[i-1][1]-prices[i] 前一天是保持卖出股票的状态 第i天买入
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length-1][3],Math.max(dp[prices.length-1][1], dp[prices.length-1][2]));
    }
}
