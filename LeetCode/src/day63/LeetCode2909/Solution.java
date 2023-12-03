package day63.LeetCode2909;

/**
 * 三元组前后缀
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
 * <p>
 * i < j < k
 * nums[i] < nums[j] 且 nums[k] < nums[j]
 * 请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
 */

class Solution {
    //三元组一般用前后缀来解决
    public int minimumSum(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = Integer.MAX_VALUE;
        int[] right = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            left[i] = Math.min(left[i - 1], nums[i - 1]);
        }
        right[nums.length - 1] = Integer.MAX_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i + 1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= nums.length - 2; i++) {
            if (nums[i] > left[i] && nums[i] > right[i]) {
                if (res > left[i] + right[i] + nums[i])
                    res = left[i] + right[i] + nums[i];
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


}