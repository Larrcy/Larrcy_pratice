package day35.LeetCode566;

public class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) return mat;
        int count = 0;
        int row = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[row][count] = mat[i][j];
                if (count < c - 1) {
                    count++;
                    continue;
                }
                if (count == c - 1 && row < r - 1) {
                    count = 0;
                    row++;
                }

            }
        }
        return res;
    }
}
