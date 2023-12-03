package day71.分组循环.LeetCode1869;

/**
 * 分组循环
 * 给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
 * <p>
 * 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。
 * 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。
 */
public class Solution {
    public boolean checkZeroOnes(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int i = 0;
        int ans1 = 0;
        int ans0 = 0;
        while (i < n) {
            int start = i;
            i++;
            char c = '0';
            while (i < n && chars[i] == chars[i - 1]) {
                c = chars[i];
                i++;
            }
            if (c == '1') {
                ans1 = Math.max(ans1, i - start);
            } else {
                ans0 = Math.max(ans0, i - start);
            }
        }
        return ans1 > ans0;
    }
}
