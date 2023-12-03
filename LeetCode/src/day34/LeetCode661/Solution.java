package day34.LeetCode661;

public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }
        //对于某个 ans[i][j]ans[i][j]ans[i][j] 而言，
        // 我们可以直接计算出其所在 item 的左上角 (a,b)=(i−1,j−1)
        // 以及其右下角 (c,d)=(i+1,j+1)
        // 同时为了防止超出原矩阵，我们需要将 (a,b)与 (c,d)对边界分别取 max 和 min。

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = Math.max(0, i - 1), b = Math.max(0, j - 1);
                int c = Math.min(m - 1, i + 1), d = Math.min(n - 1, j + 1);
                int cnt = (c - a + 1) * (d - b + 1);
                int tot = sum[c + 1][d + 1] - sum[a][d + 1] - sum[c + 1][b] + sum[a][b];
                ans[i][j] = tot / cnt;
            }
        }
        return ans;
    }

}
