package day63.SlideWindow.LeetCode2841;

import java.util.*;

/**
 * 滑动窗口
 * 给你一个整数数组 nums 和两个正整数 m 和 k 。
 * <p>
 * 请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。
 * <p>
 * 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
 * <p>
 * 子数组指的是一个数组中一段连续 非空 的元素序列。
 */
public class Solution {
    //滑动窗口+哈希表
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        long sum = 0;
        long res = 0;
        int len = 0;
        for (int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            sum += nums.get(i);
            len++;
            while (len > k) {
                if (map.get(nums.get(left)) == 1) {
                    map.remove(nums.get(left));
                } else if (map.get(nums.get(left)) > 1) {
                    map.put(nums.get(left), map.get(nums.get(left)) - 1);
                }
                sum -= nums.get(left);
                left++;
                len--;
            }
            if (len == k && map.size() >= m) {
                if (sum > res) {
                    res = sum;
                }

            }
        }
        return res;
    }
}
