package Char10.S43.LeetCode718;

public class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        //定义dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        //dp[i][0]与dp[0][j]没有意义 直接初始化为0即可
        //从1开始遍历 确保遍历到每个元素 故从1-nums.lenth
        for (int i = 1; i <= nums1.length + 1; i++) {
            for (int j = 1; j <= nums2.length + 1; j++) {
                //若当前元素相等则dp[i][j]= dp[i - 1][j - 1] + 1
                //取最大值
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result;
    }
}
