package day41.LeetCode695;

public class Solution {
    //我们想知道网格中每个连通形状的面积，然后取最大值。
    //如果我们在一个土地上，以 4个方向探索与之相连的每一个土地（以及与这些土地相连的土地），
    // 那么探索过的土地总数将是该连通形状的面积。
    //为了确保每个土地访问不超过一次，我们每次经过一块土地时，将这块土地的值置为 0。这样我们就不会多次访问同一土地。
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        int ans = 1;
        ans += dfs(grid, i + 1, j);
        ans += dfs(grid, i - 1, j);
        ans += dfs(grid, i, j + 1);
        ans += dfs(grid, i, j - 1);
        return ans;
    }

}
