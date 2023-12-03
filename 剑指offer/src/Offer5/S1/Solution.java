package Offer5.S1;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix[0].length * matrix.length];
        if (matrix == null || matrix.length == 0) return result;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int numEle = matrix.length * matrix[0].length;
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                result[result.length - numEle] = matrix[top][i];
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result[result.length - numEle] = matrix[i][right];
                numEle--;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                result[result.length - numEle] = (matrix[bottom][i]);
                numEle--;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result[result.length - numEle] = (matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return result;
    }

}

