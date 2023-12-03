package 基础算法.DP.LeetCode121;

public class Solution {
    //只买卖一次
    //考虑两个状态 持有和不持有
    //持有时有两个状态
    //1.之前已经持有 即dp[i - 1][0]
    //2.当天持有 即-prices[i]
    //不持有时也有两个状态
    //之前已经不持有 即dp[i - 1][1]
    //当天不持有 即prices[i] + dp[i - 1][0]
    //对这些状态取最大值即可
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }
        return dp[prices.length - 1][1];
    }
}
