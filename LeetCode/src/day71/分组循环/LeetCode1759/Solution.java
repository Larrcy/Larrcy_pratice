package day71.分组循环.LeetCode1759;

/**
 * 分组循环
 * 给你一个字符串 s ，返回 s 中 同质子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。
 * <p>
 * 同质字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同质字符串。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 */
public class Solution {
    public int countHomogenous(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int mod = 1000000007;
        long ans = 0;
        int i = 0;
        while (i < n) {
            int start = i;
            i++;
            while (i < n && chars[i] == chars[i - 1]) {
                i++;
            }
            ans +=  ((long) (i - start) * (i - start +1)/ 2);
            ans %= mod;
        }
        return (int) ans;

    }
}
