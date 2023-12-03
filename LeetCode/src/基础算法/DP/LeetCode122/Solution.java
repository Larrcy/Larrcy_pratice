package 基础算法.DP.LeetCode122;

public class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        //多次买卖
        //仍然考虑两个状态持有和不持有
        //持有时有两个状态
        //1.前一天不持有 当天持有 即dp[i - 1][1] - prices[i]
        //2.前一天持有 当天保持原状态 即dp[i - 1][0]
        //不持有时有两个状态
        //1.前一天持有 当天不持有 即dp[i - 1][0] + prices[i]
        //2.前一天不持有 当天保持原状态 即dp[i - 1][1]
        //最后返回所有状态的最大值
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][1];
    }
}
