package day17.LeetCode51;

import java.util.*;

public class Solution {
    public List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        //将二维数组里的值初始化（否则会出现二进制空集）
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtracking(n, 0, chessboard);
        return res;
    }


    public void backtracking(int n, int row, char[][] chessboard) {
        if (row == n) {
            //将将二维数组封装成集合再进行添加
            res.add(Array2List(chessboard));
            return;
        }
        //i表示列
        for (int i = 0; i < n; i++) {
            //若满足插入条件
            if (isValid(row, i, chessboard, n)) {
                //进行回溯
                chessboard[row][i] = 'Q';
                backtracking(n, row + 1, chessboard);
                chessboard[row][i] = '.'; // 回溯，撤销皇后
            }


        }

    }
    //将二维数组封装成集合
    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    //检查是否满足插入条件
    public static boolean isValid(int row, int col, char[][] chessboard, int n) {
        // 检查列
        for (int i = 0; i < row; i++) { // 这是一个剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查 45度角是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查 135度角是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
