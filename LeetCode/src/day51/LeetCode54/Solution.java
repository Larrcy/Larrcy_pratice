package day51.LeetCode54;

import java.util.*;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int num = matrix.length * matrix[0].length;
        while (num > 0) {
            for (int i = left; i <= right && num > 0; i++) {
                list.add(matrix[top][i]);
                num--;
            }
            top++;
            for (int i = top; i <= bottom && num > 0; i++) {
                list.add(matrix[i][right]);
                num--;
            }
            right--;
            for (int i = right; i >= left && num > 0; i--) {
                list.add(matrix[bottom][i]);
                num--;
            }
            bottom--;

            for (int i = bottom; i >= top && num > 0; i--) {
                list.add(matrix[i][left]);
                num--;
            }
            left++;
        }
        return list;

    }
}

