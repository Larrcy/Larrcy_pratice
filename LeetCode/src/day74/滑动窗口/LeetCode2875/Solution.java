package day74.滑动窗口.LeetCode2875;

/**
 * 给你一个下标从 0 开始的数组 nums 和一个整数 target 。
 * <p>
 * 下标从 0 开始的数组 infinite_nums 是通过无限地将 nums 的元素追加到自己之后生成的。
 * <p>
 * 请你从 infinite_nums 中找出满足 元素和 等于 target 的 最短 子数组，并返回该子数组的长度。如果不存在满足条件的子数组，返回 -1 。
 */
public class Solution {
    //超过两段的长度必然会包含一整个nums
    //只需要将两段nums拼接起来找最短长度即可
    //只考虑在两段拼接起来的长度上考虑求得的最小长度
    //若res=0则继续判断target包含多少段nums
    public int minSizeSubarray(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int n = nums.length;
        int sum = 0;
        int count = 0;
        long total =0;
        for (int num : nums) {
            total+=num;
        }
        for (int i = 0; i < 2 * n; i++) {
            sum += nums[i % n];
            count++;
            while (sum > target) {
                sum -= nums[left % n];
                left++;
                count--;
            }
            if (sum == target) {
                if (res > count) {
                    res = count;
                }
            }

        }
        return res==Integer.MAX_VALUE ? -1 : res + (int) (target / total) * n;
    }
}
