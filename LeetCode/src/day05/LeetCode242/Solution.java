package day05.LeetCode242;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //toArray是将字符串转化为数组
        char[] list1 = s.toCharArray();
        char[] list2 = t.toCharArray();
        Arrays.sort(list1);
        Arrays.sort(list2);
        //数组比较是否相等
        return Arrays.equals(list1, list2);
    }
}
