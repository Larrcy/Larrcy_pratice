package Char12.S1.LeetCode200;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    boolean[][] visited;
    int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int res = 0;
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    //将这片岛屿上的所有陆地都访问到
    public void bfs(char[][] grid, int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int m = cur[0];
            int n = cur[1];
            for(int i = 0; i < 4; i++) {
                int nexty = m + move[i][0];
                int nextx = n + move[i][1];
                if(nextx < 0 || nexty == grid.length || nexty < 0 || nextx == grid[0].length) continue;
                if(!visited[nexty][nextx] && grid[nexty][nextx] == '1') {
                    queue.offer(new int[]{nexty, nextx});
                    visited[nexty][nextx] = true; //只要加入队列就标记为访问
                }
            }
        }
    }
}
