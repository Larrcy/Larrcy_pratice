package day72.单调栈.LeetCode2104;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 单调栈
 * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 * <p>
 * 返回 nums 中 所有 子数组范围的 和 。
 * <p>
 * 子数组是数组中一个连续 非空 的元素序列。
 */
public class Solution {
    //我们可以考虑每个元素作为最大值出现在了多少子数组中，以及作为最小值出现在了多少子数组中。
    public long subArrayRanges(int[] nums) {
        //以最大值为例。我们可以求出 nums[i] 左侧严格大于它的最近元素位置left[i]，
        //以及右侧大于等于它的最近元素位置 right[i]。
        //nums中可能有重复元素，所以这里右侧取大于等于
        //这样可以避免在有重复元素的情况下，重复统计相同的子数组。
            int n = nums.length;
            int[] minLeft = new int[n];
            int[] minRight = new int[n];
            int[] maxLeft = new int[n];
            int[] maxRight = new int[n];
            Deque<Integer> minStack = new ArrayDeque<Integer>();
            Deque<Integer> maxStack = new ArrayDeque<Integer>();
            for (int i = 0; i < n; i++) {
                while (!minStack.isEmpty() && nums[minStack.peek()] > nums[i]) {
                    minStack.pop();
                }
                minLeft[i] = minStack.isEmpty() ? -1 : minStack.peek();
                minStack.push(i);

                // 如果 nums[maxStack.peek()] == nums[i], 那么根据定义，
                // nums[maxStack.peek()] 逻辑上小于 nums[i]，因为 maxStack.peek() < i
                while (!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]) {
                    maxStack.pop();
                }
                maxLeft[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
                maxStack.push(i);
            }
            minStack.clear();
            maxStack.clear();
            for (int i = n - 1; i >= 0; i--) {
                // 如果 nums[minStack.peek()] == nums[i], 那么根据定义，
                // nums[minStack.peek()] 逻辑上大于 nums[i]，因为 minStack.peek() > i
                while (!minStack.isEmpty() && nums[minStack.peek()] >= nums[i]) {
                    minStack.pop();
                }
                minRight[i] = minStack.isEmpty() ? n : minStack.peek();
                minStack.push(i);

                while (!maxStack.isEmpty() && nums[maxStack.peek()] < nums[i]) {
                    maxStack.pop();
                }
                maxRight[i] = maxStack.isEmpty() ? n : maxStack.peek();
                maxStack.push(i);
            }

            long sumMax = 0, sumMin = 0;
            for (int i = 0; i < n; i++) {
                sumMax += (long) (maxRight[i] - i) * (i - maxLeft[i]) * nums[i];
                sumMin += (long) (minRight[i] - i) * (i - minLeft[i]) * nums[i];
            }
            return sumMax - sumMin;
        }



}
