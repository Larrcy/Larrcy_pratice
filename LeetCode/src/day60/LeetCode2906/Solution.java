package day60.LeetCode2906;

/**
 * 给你一个下标从 0 开始、大小为 n * m 的二维整数矩阵 grid ，定义一个下标从 0 开始、大小为 n * m 的的二维矩阵 p。如果满足以下条件，则称 p 为 grid 的 乘积矩阵 ：
 * <p>
 * 对于每个元素 p[i][j] ，它的值等于除了 grid[i][j] 外所有元素的乘积。乘积对 12345 取余数。
 * 返回 grid 的乘积矩阵。
 */
public class Solution {
    /*
    核心思想：把矩阵拉成一维的，我们需要算出每个数左边所有数的乘积，以及右边所有数的乘积，这都可以用递推得到。

    先算出从 grid[i][j] 的下一个元素开始，到最后一个元素 grid[n−1][m−1]的乘积，记作 suf[i][j]。

    这可以从最后一行最后一列开始，倒着遍历得到。

    然后算出从第一个元素 grid[0][0] 开始，到 grid[i][j] 的上一个元素的乘积，记作 pre[i][j]。

    这可以从第一行第一列开始，正着遍历得到。

    那么

    p[i][j]=pre[i][j]⋅suf[i][j]

    */
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int n = grid.length, m = grid[0].length;
        int[][] p = new int[n][m];

        long suf = 1; // 后缀乘积
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int) suf; // p[i][j] 先初始化成后缀乘积
                suf = suf * grid[i][j] % MOD;
            }
        }

        long pre = 1; // 前缀乘积
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int) (p[i][j] * pre % MOD); // 然后再乘上前缀乘积
                pre = pre * grid[i][j] % MOD;
            }
        }

        return p;
    }

}
