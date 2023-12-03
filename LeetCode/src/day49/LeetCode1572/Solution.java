package day49.LeetCode1572;

public class Solution {
    public int diagonalSum(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            res += mat[i][i];
            if (mat.length - i -1== i) continue;
            res += mat[i][mat.length - i-1];
        }
        return res;
    }
}
