package day35.LeetCode419;

public class Solution {
    public int countBattleships(char[][] board) {
        //当且仅当某个 X 格子的「上方」&「左方」不为 X 时，该格子为战舰首个格子，可以进行计数，
        //同时需要注意当前行为 0（没有「上方」）和当前列为 0（没有「左方」）时的边界情况。
        int m = board.length, n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                if (board[i][j] == 'X') ans++;
            }
        }
        return ans;
    }

}
