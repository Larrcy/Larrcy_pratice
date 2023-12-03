package day63.SlideWindow.LeetCode2871;

/**
 * 滑动窗口
 给你一个只包含 非负 整数的数组 nums 。

 我们定义满足 l <= r 的子数组 nums[l..r] 的分数为 nums[l] AND nums[l + 1] AND ... AND nums[r] ，其中 AND 是按位与运算。

 请你将数组分割成一个或者更多子数组，满足：

 每个 元素都 只 属于一个子数组。
 子数组分数之和尽可能 小 。
 请你在满足以上要求的条件下，返回 最多 可以得到多少个子数组。

 一个 子数组 是一个数组中一段连续的元素。


 */

class Solution {
    public int maxSubarrays(int[] nums) {
        int ans = 0;
        int a = -1; // -1 就是 111...1，和任何数 AND 都等于那个数
        for (int x : nums) {
            a &= x;
            if (a == 0) {
                ans++; // 分割
                a = -1;
            }
        }
        return Math.max(ans, 1); // 如果 ans=0 说明所有数的 and>0，答案为 1
    }
}