package day08.LeetCode409;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String s = "bb";
        System.out.println(longestPalindrome(s));

    }

    public static int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        //count 统计偶数的个数
        int count = 0;
        //index 统计奇数个数
        int index = 1;
        //temp 排除只有偶数的特殊情况
        int temp = 0;
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            list.add(s.charAt(i));
        }
        list = list.stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) % 2 == 0) {
                count = count + map.get(list.get(i));
            } else {
                index = index + map.get(list.get(i))-1;
                    temp++;
            }
        }
        if(temp==0) index=0;
        return count + index;
    }

}

