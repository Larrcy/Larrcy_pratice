package day66.LeetCode2684;

import java.util.Arrays;

/**
 *给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。
 *
 * 你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ：
 *
 * 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1) 三个单元格中任一满足值 严格 大于当前单元格的单元格。
 * 返回你在矩阵中能够 移动 的 最大 次数。
 */
public class Solution {
    //记忆化搜索
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            result = Math.max(result, dfs(i, 0, grid, memo));
        }
        return result;
    }

    private int dfs(int i, int j, int[][] grid, int[][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        //到达最后一列不能再走了直接返回0
        if (j == n - 1) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = 0;
        //只有3个位置 直接创建一个数组循环
        for (int k : new int[]{i - 1, i, i + 1}) {
            //当k在0-m的范围内且当前位置的数小于下一个位置的数则满足条件
            //要记录最长的路径所以要取max
            if (0 <= k && k < m && grid[k][j + 1] > grid[i][j]) {
                res = Math.max(res, dfs(k, j + 1, grid, memo) + 1);
            }
        }
        //将当前位置填上数字
        memo[i][j] = res;
        return res;
    }
}
