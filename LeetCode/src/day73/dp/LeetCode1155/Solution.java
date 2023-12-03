package day73.dp.LeetCode1155;

/**
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * <p>
 * 给定三个整数 n ,  k 和 target ，返回可能的方式(从总共 kn 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
 * <p>
 * 答案可能很大，你需要对 109 + 7 取模 。
 */
public class Solution {
    //设状态dp[i][j]表示扔i个骰子这些骰子的点数之和为j
    //设扔第i个骰子所得的点数为k(1<=k<=f)
    //则前i-1次的状态为dp[i-1][j-k]
    //点数是1-f中的任意一个
    //因此我们要考虑f个dp[i-1]
    //所以dp[i][j]=dp[i-1][j-1]+...+dp[i-1][j-f]
    //边界条件dp[1][k]=1 只有一个骰子时只会出现一个点数
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = 1000000007;
        // 无法组成 target直接返回0
        if (target < n || target > n * k) {
            return 0;
        }
        //创建dp数组
        int[][] dp = new int[n + 1][k * n + 1];
        for (int i = 1; i <= k; i++) {
            dp[1][i] = 1;
        }
        int targetMax = k * n;
        //骰子个数
        for (int i = 2; i <= n; i++) {
            //点数之和
            for (int j = i; j <= targetMax; j++) {
                //单个骰子的点数
                for (int l = 1; j - l >= 0 && l <= k; l++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % MOD;
                }
            }
        }
        return dp[n][target];
    }
}
