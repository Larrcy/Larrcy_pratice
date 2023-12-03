package day71.分组循环.LeetCode1839;

import java.util.HashSet;
import java.util.Set;

/**
 * 当一个字符串满足如下条件时，我们称它是 美丽的 ：
 * <p>
 * 所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
 * 这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
 * 比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 不是美丽的 。
 * <p>
 * 给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
 * <p>
 * 子字符串 是字符串中一个连续的字符序列。
 */
public class Solution {
    public int longestBeautifulSubstring(String word) {
        char[] chars = word.toCharArray();
        int n = word.length();
        Set<Character>set=new HashSet<>();
        int ans = 0;
        int i = 0;
        while (i < n) {
            int start = i;
            set.add(word.charAt(i));
            i++;
            while (i < n && word.charAt(i) - word.charAt(i - 1) >=0) {
                set.add(word.charAt(i));
                i++;
            }
            if(set.size()==5) {
                ans = Math.max(ans, i - start);
            }
            set.clear();
            }
        return ans;
    }

}
