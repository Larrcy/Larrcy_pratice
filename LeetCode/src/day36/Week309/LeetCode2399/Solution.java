package day36.Week309.LeetCode2399;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkDistances(String s, int[] distance) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (distance[s.charAt(i) - 'a'] != i - map.get(s.charAt(i)) - 1) {
                    return false;
                }
            }
            map.put(s.charAt(i), i);
        }
        return true;
    }
}
