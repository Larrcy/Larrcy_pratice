package Char10.S50.LeetCode72;

public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    //增和删的操作数是一样的 这里只考虑删除操作
                    //删除有两种情况 对s当前位置删除 或t当前位置删除
                    //替换： 只需要对s t的前一个状态的操作再加上1次替换操作即可
                    //对这三种情况取最小值
                    dp[i][j] =Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),dp[i-1][j-1]+1 ) ;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

