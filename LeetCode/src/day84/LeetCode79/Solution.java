package day84.LeetCode79;

public class Solution {
    public char[] words;
    public boolean[][] visited;
    public int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m;
    int n;

    public boolean wordPuzzle(char[][] grid, String target) {
        words = target.toCharArray();
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(i, j, 0, grid, words)) return true;
            }
        }
        return false;
    }
    //回溯
    boolean backtracking(int i, int j, int start, char[][] grid, char[] words) {
        //道达字符串结尾进行判断
        if (start == words.length - 1) {
            return grid[i][j] == words[start];
        }
        //若当前位置的单词与字符串的单词相匹配则在grid中进一步搜索
        if (words[start] == grid[i][j]) {
            visited[i][j] = true;
            for (int[] d : dirs) {
                int newI = i + d[0];
                int newJ = j + d[1];
                //遍历过的字符不能再用
                if (inArea(newI, newJ) && !visited[newI][newJ]) {
                    //继续判断下一个位置的字符是否匹配
                    if (backtracking(newI, newJ, start + 1, grid, words))
                        return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
