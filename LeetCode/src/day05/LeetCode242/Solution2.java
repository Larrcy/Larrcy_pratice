package day05.LeetCode242;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {

    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer>map =new HashMap<>();
        Map<Character,Integer>map2 =new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }
        for (int i = 0; i <s.length(); i++) {
            if(!(map.get(s.charAt(i)).equals( map2.get(s.charAt(i))))){
                return false;
            }
        }
        return true;

    }
}
