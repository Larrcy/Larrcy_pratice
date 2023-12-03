package day61.LeetCode567;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    //滑动窗口思想
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int valid = 0;
        int left = 0;
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            while (i - left+1  == s1.length()) {
                if (valid == need.size()) return true;
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
