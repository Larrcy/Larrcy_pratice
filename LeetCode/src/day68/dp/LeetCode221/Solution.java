package day68.dp.LeetCode221;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class Solution {
    // 当 matrix[i][j] 为 1，
    // 且它的左边、上边、左上边都存在正方形时，
    // matrix[i][j] 才能够作为一个更大的正方形的右下角：
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 定义：以 matrix[i][j] 为右下角元素的全为 1 正方形矩阵的最大边长为 dp[i][j]。
        int[][] dp = new int[m][n];
        // base case，第一行和第一列的正方形边长
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
        }

        // 进行状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    // 值为 0 不可能是正方形的右下角
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }

        int len = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                len = Math.max(len, dp[i][j]);
            }
        }
        return len * len;
    }
}
