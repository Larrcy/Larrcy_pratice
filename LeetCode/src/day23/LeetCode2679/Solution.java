package day23.LeetCode2679;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[][]nums={{7,2,1},{6,4,2},{6,5,3},{3,2,1}};
        System.out.println(matrixSum(nums));
    }
    public static int matrixSum(int[][] nums) {
        int row = nums.length;
        int len = nums[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            Arrays.sort(nums[i]);
        }
        int[][] temp = new int[len][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < len; j++) {
                temp[j][i] = nums[i][j];
            }
        }
        for (int i = 0; i < len; i++) {
            Arrays.sort(temp[i]);
            res += temp[i][row - 1];
        }
        return res;

    }
}
