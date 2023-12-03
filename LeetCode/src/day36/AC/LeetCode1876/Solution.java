package day36.AC.LeetCode1876;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0;
        int count = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <= 2; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        if (map.size() == 3) count++;
        for (int i = 3; i < s.length(); i++) {
            if(map.get(s.charAt(i-3))>1){
                map.put(s.charAt(i - 3),map.get(s.charAt(i-3))-1);
            }else{
                map.remove(s.charAt(i-3));
            }
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            if (map.size() == 3) count++;
        }
        return count;

    }
}

