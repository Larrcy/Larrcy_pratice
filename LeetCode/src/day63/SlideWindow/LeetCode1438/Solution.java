package day63.SlideWindow.LeetCode1438;

import java.util.PriorityQueue;

/**
 * 滑动窗口
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 */
public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            maxpq.add(nums[i]);
            minpq.add(nums[i]);
            while (!maxpq.isEmpty()&&!minpq.isEmpty()&&Math.abs( maxpq.peek() -  minpq.peek()) > limit) {
                maxpq.remove(nums[left]);
                minpq.remove(nums[left]);
                left++;
            }
            if (sum < i - left + 1) {
                sum = i - left + 1;
            }
        }

        return sum;
    }
}
