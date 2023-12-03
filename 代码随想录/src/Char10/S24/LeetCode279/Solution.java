package Char10.S24.LeetCode279;

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i]= Integer.MAX_VALUE;
        }
        for (int i = 1; i <=Math.pow(Math.sqrt(n),2) ; i++) {
            for (int j = i*i; j <= n; j++) {
                if(j>i*i)
                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];

    }

}
