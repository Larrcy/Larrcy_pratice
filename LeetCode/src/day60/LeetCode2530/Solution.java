package day60.LeetCode2530;

import java.util.PriorityQueue;

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。
 * <p>
 * 在一步 操作 中：
 * <p>
 * 选出一个满足 0 <= i < nums.length 的下标 i ，
 * 将你的 分数 增加 nums[i] ，并且
 * 将 nums[i] 替换为 ceil(nums[i] / 3) 。
 * 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。
 * <p>
 * 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。
 */
public class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        long point = 0;
        for (int i = 0; i < k; i++) {
            int num = pq.poll();
            point += num;
            pq.add((int) Math.ceil((double) num / 3));

        }
        return point;
    }
}
