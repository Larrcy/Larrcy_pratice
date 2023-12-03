package day42.LeetCode329;
import java.util.*;
public class Solution {
    // 上下左右的方向
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        // 把符合题目要求的点连起来就是有一张有向无环图
        // 所以我们可以使用多源BFS拓扑排序寻找最短路径的思想在这里寻找最长路径
        int m = matrix.length;
        int n = matrix[0].length;
        // 记录每个节点的出度
        int[][] outDegree = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int nextI = i + dir[0];
                    int nextJ = j + dir[1];
                    // 只要旁边节点的值比它大，它的出度就加1
                    if (nextI >= 0 && nextJ >= 0 && nextI < m && nextJ < n && matrix[nextI][nextJ] > matrix[i][j]) {
                        outDegree[i][j]++;
                    }
                }
            }
        }

        // 多源BFS（可以跟上面的循环合在一起）
        // 为了更清晰，这里单独写这个循环
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (outDegree[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            // 一次遍历一批，每遍历一批，相当于最长路径又加了一
            int size = queue.size();
            for (int c = 0; c < size; c++) {
                int[] pos = queue.poll();
                int i = pos[0];
                int j = pos[1];
                for (int[] dir : dirs) {
                    int preI = i + dir[0];
                    int preJ = j + dir[1];
                    if (preI >= 0 && preI < m && preJ >= 0 && preJ < n && matrix[preI][preJ] < matrix[i][j]) {
                        // 指向当前元素的节点的出度减1，减到0了入队
                        if (--outDegree[preI][preJ] == 0) {
                            queue.offer(new int[] {preI, preJ});
                        }
                    }
                }
            }
        }

        return ans;
    }
}
