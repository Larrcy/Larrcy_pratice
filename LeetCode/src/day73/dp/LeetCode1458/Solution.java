package day73.dp.LeetCode1458;

import java.util.Arrays;

/**
 * 给你两个数组 nums1 和 nums2 。
 * <p>
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 * <p>
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 */
public class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE );
        }
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j <= n; j++) {
                int num2 = nums2[j - 1];
                dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], 0) + num1 * num2, Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m][n];
    }

}
