package day35.LeetCode498;

public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) return new int[0];
        int n = mat.length, m = mat[0].length;
        int[] res = new int[n * m];
        //定义答案数组res，遍历每条对角线。
        //2、对于每条序号为i的对角线，判断其奇偶性：
        //如果是偶数对角线 ，确定其横坐标x，从下往上遍历，将mat[x][i - x]加入res中。
        //如果是奇数对角线 ，确定其横坐标x，从上往下遍历，将mat[x][i - x]加入 res中。
        //3、最后返回res。
        for (int i = 0, idx = 0; i < n + m - 1; i++) {
            if (i % 2 == 0) //偶数对角线
                for (int x = Math.min(i, n - 1); x >= Math.max(0, i - m + 1); x--) //从下往上遍历
                    res[idx++] = mat[x][i - x];
            else            //奇数对角线
                for (int x = Math.max(0, i - m + 1); x <= Math.min(i, n - 1); x++)//从上往下遍历
                    res[idx++] = mat[x][i - x];
        }
        return res;
    }


}


