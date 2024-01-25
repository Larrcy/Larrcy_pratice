package day81.LeetCode2370;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个由小写字母组成的字符串 s ，和一个整数 k 。如果满足下述条件，则可以将字符串 t 视作是 理想字符串 ：
 *
 * t 是字符串 s 的一个子序列。
 * t 中每两个 相邻 字母在字母表中位次的绝对差值小于或等于 k 。
 * 返回 最长 理想字符串的长度。
 */
public class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            for (int j = 0; j <= k; j++) {
                char t1 = (char) (c - j);
                char t2 = (char) (c + j);
                if (map.containsKey(t1)) {
                    dp[i] = Math.max(dp[i], map.get(t1) + 1);
                }
                if (map.containsKey(t2)) {
                    dp[i] = Math.max(dp[i], map.get(t2) + 1);
                }
            }
            map.put(c, dp[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
