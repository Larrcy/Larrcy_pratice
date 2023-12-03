package 基础算法.DP.LeetCode188;

public class Solution {
    //k次交易 即2k次买卖
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 0; i < 2 * k + 1; i++) {
            if (i % 2 != 0) {
                dp[0][i] = -prices[0];
            }
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 != 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}
