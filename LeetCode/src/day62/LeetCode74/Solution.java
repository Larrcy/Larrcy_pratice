package day62.LeetCode74;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * <p>
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            int left = 0;
            int right = col - 1;
            while (left <= right) {
                int mid = left + right >> 1;
                if (matrix[i][mid] == target) {
                    return true;
                }
                if (matrix[i][mid] > target) {
                    right = mid - 1;
                }
                if (matrix[i][mid] < target) {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
