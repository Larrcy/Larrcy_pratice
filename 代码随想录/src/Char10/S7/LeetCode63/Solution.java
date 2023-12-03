package Char10.S7.LeetCode63;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //取出行和列
        int m =obstacleGrid.length;
        int n =obstacleGrid[0].length;
        int[][]dp =new int[m][n];
        //对有障碍的地方进行判断
        for (int i = 0; i <m; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else break;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] != 1) {
                dp[0][j] = 1;
            } else break;

        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //当中间位置没有障碍的时候才能进行路径计算
                if(obstacleGrid[i][j]==0)
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    }

