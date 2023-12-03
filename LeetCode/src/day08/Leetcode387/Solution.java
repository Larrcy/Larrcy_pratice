package day08.Leetcode387;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        if(s.length()==1){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //map记录字符和出现的次数
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int i =0;
        while (i<s.length()) {
            //判断是否是仅一次出现
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
            i++;

        }
        return -1;
    }
}
