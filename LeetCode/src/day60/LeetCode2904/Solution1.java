package day60.LeetCode2904;

/**
 * 给你一个二进制字符串 s 和一个正整数 k 。
 * 如果 s 的某个子字符串中 1 的个数恰好等于 k ，则称这个子字符串是一个 美丽子字符串 。
 * 令 len 等于 最短 美丽子字符串的长度。
 * 返回长度等于 len 且字典序 最小 的美丽子字符串。如果 s 中不含美丽子字符串，则返回一个 空 字符串。
 * 对于相同长度的两个字符串 a 和 b
 * 如果在 a 和 b 出现不同的第一个位置上
 * a 中该位置上的字符严格大于 b 中的对应字符
 * 则认为字符串 a 字典序 大于 字符串 b 。
 * 例如，"abcd" 的字典序大于 "abcc" ，因为两个字符串出现不同的第一个位置对应第四个字符，而 d 大于 c 。
 */
public class Solution1 {
    /*
     * 法一 枚举
     * 若s中1的个数不足k则直接返回空串
     * 否则一定有解
     * 因此从k开始枚举答案的长度 然后再s中枚举所有长度为size的子串
     * 同时维护字典序最小的子串
     * 直到遍历结束
     * */
    public String shortestBeautifulSubstring(String s, int k) {
        if (s.replaceAll("0", "").length() < k) {
            return "";
        }
        for (int size = k; ; size++) {
            String ans = "";
            for (int i = size; i <= s.length(); i++) {
                String t = s.substring(i - size, i);
                if ((ans.isEmpty() || t.compareTo(ans) < 0) && t.replaceAll("0", "").length() == k) {
                    ans = t;
                }
            }
            if (!ans.isEmpty()) {
                return ans;
            }
        }
    }
}
