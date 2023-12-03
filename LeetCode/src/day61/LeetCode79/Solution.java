package day61.LeetCode79;

public class Solution {
    public static   void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "SEE"));
    }

    public static int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public static int rows;
    public static int cols;
    public static int len;
    public static boolean[][] visited;
    public static char[] charArray;
    public static char[][] Board;

    public static boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        len = word.length();
        charArray = word.toCharArray();
        Board = board;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int x, int y, int begin) {
        //递归出口 此时我们收集的字符串长度与word相同 进行比较
        if (begin == len - 1) {
            return Board[x][y] == charArray[begin];
        }
        if (Board[x][y] == charArray[begin]) {
            visited[x][y] = true;
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }
            //若中途有不匹配的字符则将该字符重置状态
            visited[x][y] = false;
        }
        return false;
    }

    private static boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
