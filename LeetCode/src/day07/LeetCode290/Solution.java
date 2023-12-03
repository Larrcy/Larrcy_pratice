package day07.LeetCode290;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] res = s.split(" ");
        //保证键值唯一对应要创建两个map
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> pam = new HashMap<>();
        if (res.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < res.length; i++) {

            if (map.containsKey(pattern.charAt(i))) {
                if (!(res[i].equals(map.get(pattern.charAt(i))))) {
                    return false;
                }
            }
            if (pam.containsKey(res[i])) {
                if ((pattern.charAt(i)!=pam.get(res[i]))){
                    return false;
                }
            }
            map.put(pattern.charAt(i), res[i]);
            pam.put(res[i], pattern.charAt(i));
        }

        if (map.size() == 1) {
            return true;
        }

        return true;
    }
}
