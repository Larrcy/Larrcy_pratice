package day35.LeetCode467;

import java.util.Arrays;

public class Solution {
    // dp[α]表示 p中以字符 α结尾且在s中的子串的最长长度
    //知道了最长长度，也就知道了不同的子串的个数。
    //如何计算 dp[α]
    // 我们可以在遍历 p 时，维护连续递增的子串长度 k。
    // 具体来说，遍历到 p[i]时，如果 p[i] 是 p[i−1]在字母表中的下一个字母，则将 k 加一，
    // 否则将 k 置为 1，表示重新开始计算连续递增的子串长度。然后，用 k更新 dp[p[i]] 的最大值。

    public int findSubstringInWraproundString(String p) {
        //维护以每个字符结尾的最长子串长度，就可以直接累加所有以该字符结尾的子字符串
        // (每个字符统计最长长度即可。因为更小的长度都是更长的长度的子串)
        //最后进行求和统计
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) { // 字符之差为 1 或 -25
                ++k;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }

}
