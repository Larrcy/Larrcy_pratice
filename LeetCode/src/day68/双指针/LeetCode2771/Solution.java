package day68.双指针.LeetCode2771;

public class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        if (n == 1) return 1;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            // 给定一个初值，可以理解为以i处元素结尾的连续子数组的长度为1
            // 这样可以保证在i处元素都小于nums1[i-1]和nums2[i-1]时有默认值
            dp[i][0] = dp[i][1] = 1;
            // 1 当nums1[i] >= nums1[i-1]时，此时以nums1[i]结尾的连续子数组的长度就是以nums1[i-1]结尾的连续子数组长度+1
            if (nums1[i] >= nums1[i-1]) dp[i][0] = Math.max(dp[i][0], dp[i-1][0]+1);
            // 2 当nums1[i] >= nums2[i-1]时，此时以nums1[i]结尾的连续子数组的长度就是以nums2[i-1]结尾的连续子数组长度+1
            if (nums1[i] >= nums2[i-1]) dp[i][0] = Math.max(dp[i][0], dp[i-1][1]+1);
            // 3 当nums2[i] >= nums1[i-1]时，此时以nums2[i]结尾的连续子数组的长度就是以nums1[i-1]结尾的连续子数组长度+1
            if (nums2[i] >= nums1[i-1]) dp[i][1] = Math.max(dp[i][1], dp[i-1][0]+1);
            // 4 当nums2[i] >= nums2[i-1]时，此时以nums2[i]结尾的连续子数组的长度就是以nums2[i-1]结尾的连续子数组长度+1
            if (nums2[i] >= nums2[i-1]) dp[i][1] = Math.max(dp[i][1], dp[i-1][1]+1);
            // 比较连续子数组的最大长度
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        return ans;
    }
}
