package day66.LeetCode2934;

/**
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，这两个数组的长度都是 n 。
 * <p>
 * 你可以执行一系列 操作（可能不执行）。
 * <p>
 * 在每次操作中，你可以选择一个在范围 [0, n - 1] 内的下标 i ，并交换 nums1[i] 和 nums2[i] 的值。
 * <p>
 * 你的任务是找到满足以下条件所需的 最小 操作次数：
 * <p>
 * nums1[n - 1] 等于 nums1 中所有元素的 最大值 ，即 nums1[n - 1] = max(nums1[0], nums1[1], ..., nums1[n - 1]) 。
 * nums2[n - 1] 等于 nums2 中所有元素的 最大值 ，即 nums2[n - 1] = max(nums2[0], nums2[1], ..., nums2[n - 1]) 。
 * 以整数形式，表示并返回满足上述 全部 条件所需的 最小 操作次数，如果无法同时满足两个条件，则返回 -1 。
 */
class Solution {
    //只需要考虑两个数组的最后一位
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int max = Math.max(nums2[n - 1], nums1[n - 1]);
        int min = Math.min(nums2[n - 1], nums1[n - 1]);
        int ans = 0, ans2 = 0;
        if (nums2[n - 1] == min) {
            ans2 = 1;
        } else {
            ans = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums2[i] > max || nums1[i] > max) return -1;
            if (nums2[i] > min && nums1[i] > min) return -1;
            if (nums2[i] > min) {
                ans++;
            }
        }
        nums2[n - 1] = max;
        nums1[n - 1] = min;
        for (int i = n - 2; i >= 0; i--) {
            if (nums2[i] > max || nums1[i] > max) return -1;
            if (nums2[i] > min && nums1[i] > min) return -1;
            if (nums1[i] > min) {
                ans2++;
            }
        }
        return Math.min(ans, ans2);
    }
}