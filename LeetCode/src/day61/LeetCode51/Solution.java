package day61.LeetCode51;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        for (int i = 0; i < n; i++) {
            board.add(sb.toString());
        }
        backtracking(board, 0, n);
        return res;
    }

    //row表示要放在第几行
    void backtracking(List<String> board, int row, int n) {
        //放到最后一行则收集结果
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
        }
        //尝试往每一列放皇后
        for (int i = 0; i < n; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }
            char[] c = board.get(row).toCharArray();
            //将第i列放上皇后
            c[i] = 'Q';
            //将这一行修改为放皇后的状态
            board.set(row, String.valueOf(c));
            backtracking(board, row + 1, n);
            //撤销操作
            c[i] = '.';
            board.set(row, String.valueOf(c));
        }
    }

    // 是否可以在 board[row][col] 放置皇后
    //因为是从上往下放 只需要判断3个位置即可
    //上方 及左上方 右上方是否有棋子
    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

}
