package day64.贪心.LeetCode2592;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。你需要将 nums 重新排列成一个新的数组 perm 。
 * <p>
 * 定义 nums 的 伟大值 为满足 0 <= i < nums.length 且 perm[i] > nums[i] 的下标数目。
 * <p>
 * 请你返回重新排列 nums 后的 最大 伟大值。
 */
public class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        int res = 0;
        int index = 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur > nums[index]) {
                res++;
                index++;
            }
            if (index == nums.length) break;
        }
        return res;
    }
}
