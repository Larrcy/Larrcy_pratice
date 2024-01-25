package day76.LeetCode49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = Arrays.toString(chars);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
                map.get(s).add(str);
            } else {
                map.get(s).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
