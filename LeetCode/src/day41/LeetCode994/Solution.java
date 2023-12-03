package day41.LeetCode994;

import java.util.*;

public class Solution {
    public int orangesRotting(int[][] grid) {
        //1.定义2个int数组，2个一组来记录腐烂橘子的上下左右位置。腐烂橘子(0，0)
        //在矩阵中 上{-1,0}   下{1,0}  左{0,-1}   右{0,1}
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int step = 0;//感染次数
        int flash = 0;//新鲜橘子数（后面用于判定是否为-1）

        int row = grid.length;//所给矩阵行
        int col = grid[0].length;//列

        Queue<int[]> queue = new ArrayDeque<>();
        //2.遍历矩阵 将所有的腐烂橘子入队，并且记录初始新鲜橘子数
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    flash++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        //3.遍历所有腐烂橘子，同时感染四周
        while (flash > 0 && !queue.isEmpty()) {//有橘子且队列不空
            step++;
            //队列中现有的所有腐烂橘子都要进行一次感染
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] poll = queue.poll();//腐烂橘子
                for (int i = 0; i < 4; i++) {
                    //4个位置dx[i] dy[i]  ， xy 为要感染的橘子位置
                    int x = poll[0] + dx[i];//第x行
                    int y = poll[1] + dy[i];//第y列
                    if ((x >= 0 && x < row) && (y >= 0 && y < col) && grid[x][y] == 1) {
                        //xy不越界，并且要感染的地方是 新鲜橘子
                        grid[x][y] = 2;
                        //把被感染的橘子 入队
                        queue.offer(new int[]{x, y});
                        //新鲜橘子-1
                        flash--;
                    }
                }
            }

        }

        //感染完了之后如果还有新鲜橘子
        if (flash > 0) {
            return -1;
        } else {
            return step;
        }
    }
}
