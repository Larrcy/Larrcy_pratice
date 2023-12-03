package day66.LeetCode2915;

import java.util.Arrays;
import java.util.List;

public class Solution {
    // 0-1背包问题，求恰好装满背包的最长子序列长度
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        // 创建一个数组f用于记录状态转移过程中的最优解
        int[] f = new int[target + 1];
        // 将数组f的所有元素初始化为负无穷，表示未经过状态转移时的无效值
        Arrays.fill(f, Integer.MIN_VALUE);
        // 当容量为0时，表示背包已经装满，因此长度为0
        f[0] = 0;
        // 记录当前累积和，初始化为0
        int s = 0;
        // 遍历nums数组中的每个元素
        for (int num : nums) {
            // 更新当前累积和，但不超过目标值target
            s = Math.min(s + num, target);
            // 从后往前遍历，更新数组f保证每个数只用一次
            for (int j = s; j >= num; j--) {
                // 更新f[j]，选择不装入当前元素或装入当前元素，取较大值
                f[j] = Math.max(f[j], f[j - num] + 1);
            }
        }
        // 如果f[target]大于0，表示存在满足条件的子序列，返回最大长度；否则，返回-1
        return f[target] > 0 ? f[target] : -1;
    }
}
