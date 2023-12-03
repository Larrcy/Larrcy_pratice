package day66.LeetCode2874;

import java.util.PriorityQueue;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。
 * <p>
 * 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
 */
public class Solution {
    //枚举中间看左右两侧的最大值
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        int len = nums.length;
        int[] lMax = new int[len];
        int[] rMax = new int[len];

        //左侧
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            lMax[i] = max;
            max = Math.max(max, nums[i]);
        }

        //右侧
        max = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rMax[i] = max;
            max = Math.max(max, nums[i]);
        }

        for (int i = 1; i <= len - 2; i++)
            res = Math.max(res, (long) (lMax[i] - nums[i]) * rMax[i]);

        return res;
    }



}
