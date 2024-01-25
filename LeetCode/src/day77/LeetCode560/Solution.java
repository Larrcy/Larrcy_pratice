package day77.LeetCode560;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < sum.length; i++) {
            //单个字符相等的情况单独记录进结果
            if (sum[i] == k) res++;
            //两数之和的解法
            if (map.containsKey(sum[i] - k)) {
                res += map.get(sum[i] - k);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return res;
    }
}
