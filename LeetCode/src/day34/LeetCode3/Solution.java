package day34.LeetCode3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.containsKey(s.charAt(right))) {
                map.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
