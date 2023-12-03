package Char10.S45.LeetCode1035;

public class Solution {
    //本质为最长公共子序列
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
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
        return dp[nums1.length][nums2.length];
    }
}

