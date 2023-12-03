package day41.LeetCode542;

import java.util.*;

public class Solution {
    public static int[][] updateMatrix(int[][] mat) {
        // 把0的每个坐标放进队列
        Queue<int[]> queue = new LinkedList<>(); // 存储坐标
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1; // 未访问过的1标为-1，以避免和距离1混淆（原数组上改）
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};// 遍历的x方向
        int[] dy = {0, 0, -1, 1};// 遍历的y方向
        while (!queue.isEmpty()) { // queue不为空
            int[] point = queue.poll(); // 坐标出列，{x,y}
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; // 邻居坐标
                int ny = y + dy[i];
                // 0到0的最短距离为0，所以不管0，只管-1（未访问过的1标为-1）
                if (nx < m && ny < n && nx >= 0 && ny >= 0 && mat[nx][ny] == -1) {
                    // 每个-1的最短距离都是由邻居的最短距离得来的，即邻居最短距离+1
                    // 例如-1的邻居是0，0到0的最短距离就是0，则，-1对应的距离为0+1
                    mat[nx][ny] = mat[x][y] + 1;
                    queue.offer(new int[] {nx,ny}); // 把新的坐标放进去队列，以便遍历下一个邻居
                }
            }
        }
        // 跳到这里即队列为空，则证明全部已经遍历完成，返回mat
        return mat;
    }

}
