package day24.LeetCode73;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> len = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    len.add(j);
                }
            }
        }
        for (Integer rows : row) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[rows][j] = 0;
            }
        }
        for (Integer lens : len) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][lens] = 0;
            }
        }

    }
}
