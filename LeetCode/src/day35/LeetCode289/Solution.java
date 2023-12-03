package day35.LeetCode289;

public class Solution {
    public void gameOfLife(int[][] board) {
        // 对应技巧2，用一个长度为8的数组来保存遍历每一个位置时，其周边位置的相对坐标偏移
        int[] x = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] y = {1, -1, 1, -1, 0, 1, -1, 0};
        // 对应技巧1，第一次遍历，把需要变化状态的位置保存为中间值
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int curX, curY;
                int live = 0;
                // 对应技巧2，通过之前保存的相对坐标偏移的数组，方便的遍历所有的周边位置。
                for (int k = 0; k < 8; k++) {
                    curX = i + x[k];
                    curY = j + y[k];
                    if (curX < 0 || curX >= board.length || curY < 0 || curY >= board[0].length) {
                        continue;
                    }
                    // 对应技巧1,这里的0,1是题目里合理的值，然后如果0要变1，我们用中间值-1记录,
                    //我们统计活细胞的数量 由于是同时发生变化 故我们用 2来表示将要死亡的细胞
                    //1 是一直或者的细胞
                    //复活的细胞不会干扰本次的操作
                    //这样不会干扰我们之后的判断
                    if (board[curX][curY] == 1 || board[curX][curY] == 2) {
                        live++;
                    }
                }
                if (board[i][j] == 0) {
                    if (live == 3) {
                        board[i][j] = -1;
                    }
                } else {
                    if (live < 2 || live > 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        // 对应技巧1，第二次遍历，把中间值-1和2刷新为1和0
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }


}

