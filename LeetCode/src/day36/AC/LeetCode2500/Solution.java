package day36.AC.LeetCode2500;

import java.util.Arrays;

public class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int[][] index = new int[grid[0].length][grid.length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Arrays.sort(grid[i]);
                grid[i][j] = index[j][i];
            }
        }
        for (int i = 0; i < index.length; i++) {
            for (int j = 0; j < index[0].length; j++) {
                Arrays.sort(index[i]);
                res += index[i][index[0].length - 1];
            }
        }
        return res;
    }
}
