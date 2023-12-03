package LeetCode75_3.LeetCode2352;

import java.util.Arrays;

public class Solution2 {
    class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length;
            int[][] grid2 = new int[n][n];
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //转置矩阵
                    grid2[i][j] = grid[j][i];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (Arrays.equals(grid[i], grid2[j]))
                        //然后第一个矩阵的第一行和转置矩阵的每一行比较
                        res++;
                    //之后以此类推
                }
            }
            return res;
        }
    }
}
