package Offer10.S3;

public class Solution {
    public int maxProfit(int[] prices) {
        //将状态分为买入股票和卖出股票
        int[][] dp = new int[prices.length][2];
        //0 买入 1卖出
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][1];
    }
}
