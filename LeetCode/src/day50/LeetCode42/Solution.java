package day50.LeetCode42;

public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        //分别求前缀和后缀的最大值然后再与高度相减
        int[] preSum = new int[n];
        int[] sufSum = new int[n];
        preSum[0] = height[0];
        sufSum[n - 1] = height[n - 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = Math.max(height[i - 1], height[i]);
        }
        for (int i = n - 2; i >=0; i--) {
            sufSum[i] = Math.max(height[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(preSum[i], sufSum[i]) - height[i];
        }
        return res;

    }
}
