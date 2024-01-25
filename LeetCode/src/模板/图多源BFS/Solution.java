package 模板.图多源BFS;

import java.util.LinkedList;
import java.util.Queue;
//BFS按层寻找 找到的一定是最短路
public class Solution {
    int m;
    int n;

    public int f(int m, int n, int[][] board) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int res = 0;
        int flash = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (board[i][j] == 1) flash++;
            }
        }
        while (flash > 0 && !queue.isEmpty()) {
            res++;
            int len = queue.size();
            while (len > 0) {
                int[] node = queue.poll();
                for (int[] d : dirs) {
                    int newI = node[0] + d[0];
                    int newJ = node[1] + d[1];
                    if (!inArea(newI, newJ)) continue;
                    if (board[newI][newJ] == 1) {
                        flash--;
                        board[newI][newJ] = 2;
                        queue.add(new int[]{newI, newJ});
                    }
                }
                len--;
            }
        }
        if (flash != 0) return -1;
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
