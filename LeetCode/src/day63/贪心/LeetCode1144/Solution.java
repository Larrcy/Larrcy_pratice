package day63.贪心.LeetCode1144;

/**
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * <p>
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * <p>
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 */
public class Solution {
    public int movesToMakeZigzag(int[] nums) {
        //s[0], s[1]对应修改奇数下标和偶数下标的次数
        int[] s = new int[2];
        for (int i = 0, n = nums.length; i < n; ++i) {
            //为了使操作次数尽量少
            //nums[i]不断减小到要比左右相邻数字都小，就立刻停止。
            //nums[i] 要修改成 m=min(nums[i−1],nums[i+1])−1
            //修改次数为 nums[i]−m
            //若nums[i]本身就比nums[i−1],nums[i+1]小 则无需改变
            //分别对奇偶进行讨论
            int left = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i < n - 1 ? nums[i + 1] : Integer.MAX_VALUE;
            s[i % 2] += Math.max(nums[i] - Math.min(left, right) + 1, 0);
        }
        return Math.min(s[0], s[1]);
    }

}
