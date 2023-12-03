package day39.LeetCode1314;

public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] ans = new int[mat.length][mat[0].length];
        int[][] preSum =new int[mat.length+1][mat[0].length+1];
        for (int i = 1; i <= ans.length; i++)
            for (int j = 1; j <= ans[0].length; j++)
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + mat[i-1][j-1];
        for (int i = 1; i <= ans.length; i++) {
            for (int j = 1; j <= ans[0].length; j++) {
                int m = i - k < 1 ? 1 : i - k;
                int n = j - k < 1 ? 1 : j - k;
                int p = i + k > mat.length  ? mat.length  : i + k;
                int q = j + k > mat[0].length  ? mat[0].length  : j + k;
                ans[i-1][j-1]=preSum[p][q] - preSum[m-1][q] -preSum[p][n-1]+preSum[m-1][n-1];
            }
        }
        return ans;
    }
}
