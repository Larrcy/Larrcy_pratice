package day63.SlideWindow.LeetCode1358;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * <p>
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 */
public class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() == 3) {
                sum += (s.length() - i);
                if (map.get(s.charAt(left)) == 1) {
                    map.remove(s.charAt(left));
                } else if (map.get(s.charAt(left)) > 1) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                }
                left++;
            }
        }
        return sum;
    }
}
