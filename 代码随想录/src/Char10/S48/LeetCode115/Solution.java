package Char10.S48.LeetCode115;

public class Solution {
    public int numDistinct(String s, String t) {
        //dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < t.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                //若s t在相同位置的元素相等 则有两种情况
                //1.考虑在该位置前一个位置的情况
                //2.考虑将该位置的元素删除再进行匹配(将该位置元素删除后也有可能与t相等)
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else//若s t在相同位置的元素不相等则只需考虑将当前位置的元素删除即可
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[s.length()][t.length()];
    }
}
