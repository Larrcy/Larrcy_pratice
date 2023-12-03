package day71.分组循环.LeetCode1957;

/**
 * 分组循环
 * 一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
 * <p>
 * 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
 * <p>
 * 请你返回删除后的字符串。题目数据保证答案总是 唯一的
 */
public class Solution {
    public String makeFancyString(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int ans = 1;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            char c = chars[i];
            sb.append(c);
            i++;
            while (i < n && chars[i] == chars[i - 1]) {
                i++;
                ans++;
                if (ans < 3) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
