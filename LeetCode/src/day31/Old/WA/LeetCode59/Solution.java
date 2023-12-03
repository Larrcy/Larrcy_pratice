package day31.Old.WA.LeetCode59;
//螺旋矩阵
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loop = 0;
        int start = 0;
        int count = 1;
        int i, j;
        while (loop++ < n / 2) {
            //第一行从左到右
            //设n为4
            //第一行首先在0-2位置放上数
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;

            }
            //j跳出循环后j所指位置为最后一列
            //在最后一列的0-2位置放上数
            for ( i = start; i <n-loop; i++) {
                res[i][j]=count++;
            }
            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }
            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }
        //奇数时填充最后一位
        if (n % 2 == 1) {
            res[start][start] = count;
        }
        return res;

    }
}
