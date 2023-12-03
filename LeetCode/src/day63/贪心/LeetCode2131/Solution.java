package day63.贪心.LeetCode2131;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
 * <p>
 * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
 * <p>
 * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
 * <p>
 * 回文串 指的是从前往后和从后往前读一样的字符串。
 */
public class Solution {
    public int longestPalindrome(String[] words) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        //temp统计是否有aa这种类型的字符串最大出现次数是否是奇数
        //若是奇数则取该奇数其他全取偶数
        int temp = 0;
        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1)) {
                if (temp < map.get(key) && map.get(key) % 2 != 0) {
                    temp = map.get(key);
                }
            } else {
                //判断是否有匹配的回文串
                StringBuilder sb = new StringBuilder(key);
                if (map.containsKey(sb.reverse().toString())) {
                    res += 2 * Math.min(map.get(key), map.get(sb.toString()));
                    map.put(key, 0);
                    map.put(sb.toString(), 0);
                }
            }
        }
        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1)) {
                if (map.get(key) % 2 == 0) {
                    res += map.get(key);
                } else {
                    res += map.get(key) - 1;
                }
            }
        }
        return (res + (temp == 0 ? 0 : 1)) * 2;
    }
}
