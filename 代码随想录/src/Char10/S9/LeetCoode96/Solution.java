package Char10.S9.LeetCoode96;

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //dp[i] += dp[j - 1] * dp[i - j];
        // j-1 为j为头结点左子树节点数量，i-j 为以j为头结点右子树节点数量
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i]+= dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
