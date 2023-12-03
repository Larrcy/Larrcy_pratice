package day64.贪心.LeetCode2567;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * nums 的 最小 得分是满足 0 <= i < j < nums.length 的 |nums[i] - nums[j]| 的最小值。
 * nums的 最大 得分是满足 0 <= i < j < nums.length 的 |nums[i] - nums[j]| 的最大值。
 * nums 的分数是 最大 得分与 最小 得分的和。
 * 我们的目标是最小化 nums 的分数。你 最多 可以修改 nums 中 2 个元素的值。
 * <p>
 * 请你返回修改 nums 中 至多两个 元素的值后，可以得到的 最小分数 。
 * <p>
 * |x| 表示 x 的绝对值。
 */
public class Solution {
    public int minimizeSum(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;
        // 1. 前后两个
        int res1 = nums[len - 2] - nums[1];
        // 2. 前面两个
        int res2 = nums[len - 1] - nums[2];
        // 3. 后面两个
        int res3 = nums[len - 3] - nums[0];
        return Math.min(res1, Math.min(res2, res3));
    }


}
