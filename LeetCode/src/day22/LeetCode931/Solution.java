package day22.LeetCode931;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //动态规划
        //定义dp[i][j]为到达[i,j]位置的最小路径
        int[][] dp = new int[matrix.length][matrix[0].length];
        //对第一行初始化
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j];
        }
        //dp[i][j]有三种情况
        //1.dp[i][0]的情况即所求元素在第一列 此时只能通过dp[i - 1][0]和dp[i - 1][1]推得
        //2.dp[i][matrix.length-1]的情况即所求元素在最后一列 此时只能通过dp[i - 1][dp[0].length - 2]和dp[i - 1][dp[0].length - 1]推得
        //3.j在[1,matrix.length-2]的情况 此时可以通过dp[i - 1][j - 1] dp[i - 1][j] dp[i - 1][j + 1]推得
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + matrix[i][0], dp[i - 1][1] + matrix[i][0]);
            for (int j = 1; j < dp[0].length - 1; j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + matrix[i][j], dp[i - 1][j] + matrix[i][j]), dp[i - 1][j + 1] + matrix[i][j]);
            }
            dp[i][dp[0].length - 1] = Math.min(dp[i - 1][dp[0].length - 2] + matrix[i][dp[0].length - 1], dp[i - 1][dp[0].length - 1] + matrix[i][dp[0].length - 1]);

        }
        //题目要求下降路径的最小和
        //我们只需从dp数组的最后一行寻找即可
        int res = dp[matrix.length - 1][0];
        for (int i = 1; i < matrix.length; i++) {
            if (res > dp[matrix.length - 1][i])
                res = dp[matrix.length - 1][i];
        }
        return res;
    }
}
