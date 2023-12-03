package Char10.S44.LeetCode1143;

import java.util.logging.Level;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.equals(text2)) return text1.length();
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]+1;

                } else {
                    //a b c
                    //a c e
                    //若 c e所在的位置不相等 则当前位置的最大长度可以由
                    //abc 与ac 取值或者 ab 与ace取值
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
