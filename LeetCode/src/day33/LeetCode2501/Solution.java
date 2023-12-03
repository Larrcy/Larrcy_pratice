package day33.LeetCode2501;

import java.util.HashSet;

public class Solution {
    public int longestSquareStreak(int[] nums) {
        // 构造哈希集合，记录出现过的数字。转long型，避免求平方后int越界
        HashSet<Long> numSet = new HashSet<>();
        for (long num : nums) {
            numSet.add(num);
        }

        int maxLen = -1;
        // 直接枚举。依题意找到子序列后从小到大排序。因此无需排序，无需判断索引大小
        for (long num : nums) {
            int subLen = 1;
            num *= num;
            // 若包含平方数，继续枚举
            while (numSet.contains(num)) {
                subLen++;
                num *= num;
            }
            // 更新最值。子序列的长度至少为2
            if (subLen > 1 && subLen > maxLen) {
                maxLen = subLen;
            }
        }

        return maxLen;
    }

}
