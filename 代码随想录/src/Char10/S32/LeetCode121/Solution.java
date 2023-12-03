package Char10.S32.LeetCode121;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
    int[][]dp =new int[prices.length][2];
    //0表示持有股票 1表示不持有股票
    dp[0][0]=-prices[0];
    dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]= Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][1];
    }
}
