package day40.LeetCode200;

public class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    infect(grid, i, j);
                }
            }
        }
        return islands;
    }

    //从i j位置出发把连成一片的岛屿全部删除
    private void infect(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1||grid[i][j]!='1') {
            return;
        }
        grid[i][j] = '0';
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);

    }
}
